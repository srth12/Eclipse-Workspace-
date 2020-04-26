
from bs4 import BeautifulSoup as soup  # HTML data structure
from home_value import HomeValue
from key_enum import AttributeEnum
import ssl
import urllib.parse
import urllib.request
import re
import os
import sys

user_agent = 'Mozilla/5.0 (Windows NT 6.1; Win64; x64)'
values = {'name': 'Michael Foord',
          'location': 'Northampton',
          'language': 'Python' }
headers = {'User-Agent': user_agent}

data = urllib.parse.urlencode(values)
data = data.encode('ascii')
context = ssl._create_unverified_context()



class HomePriceScrapper:

    def __init__(self):

        self._url_template = "https://www.zillow.com/{location}/home-values/"
        self._base_url = "https://www.zillow.com"

        self.context = ssl._create_unverified_context()

        self._homevalue = HomeValue()

    @staticmethod
    def scrap_home_values(location):

        homescrapper = HomePriceScrapper()
        url = homescrapper._url_template.format(location=location)
        print(url)
        homescrapper.set_page_source(url)
        homescrapper.scrap_and_dump_data(location)
        nearby_hrefs = homescrapper.get_all_nearby_region_href()
        for href in nearby_hrefs:
            nearby_homescrapper = HomePriceScrapper()
            nearby_url = nearby_homescrapper._base_url + href
            print("*** nearby rul:{}".format(nearby_url))
            nearby_homescrapper.set_page_source(nearby_url)
            location = href.split("/")
            nearby_homescrapper.scrap_and_dump_data(location[1])


    def scrap_and_dump_data(self, location):
        self.get_market_temperature()
        process_sections = ["Market Overview", "Market Health", "Rentals", "Listings and Sales"]
        self.get_yoy_change()

        self.process_market_health(process_sections)

        self.write_data_as_json(location)
        self.write_data_as_csv(location)


    def get_pattern_with_whitespace(self, dirty_string):
        pattern = re.compile(r'\s*%s\s*' % dirty_string)
        return pattern

    def set_page_source(self, page_url, parser_type="html.parser"):

        req = urllib.request.Request(page_url, data, headers)
        with urllib.request.urlopen(req, context=context) as response:

            self.page_soup = soup(response.read(), parser_type)

    def get_yoy_change(self):
        forecast_chart_hdr = self.page_soup.find("header", {"class": "forecast-chart-hdr"})
        containers = forecast_chart_hdr.findAll("li", {"class": "zsg-lg-1-2"})
        for container in containers:
            if container.span.text == '1-year change':
                change_perc = container.contents[0]
                self._homevalue._one_year_change= change_perc

    def get_market_temperature(self):
        containers = self.page_soup.findAll("div", {"class": "zsg-h2"})
        if len(containers) > 0:
            self._homevalue._market_temperature = containers[0].text

    def get_sqft_price(self):
        containers = self.page_soup.findAll("span", {"class": "yui_3_18_1_1_1587802421734_2485"})
        return containers[0].text

    def set_market_overview_items(self, input):
        if AttributeEnum.MEDIAN_LIST_PRICE.value in input:
            self._homevalue._median_listing_price = input[AttributeEnum.MEDIAN_LIST_PRICE.value]
        if AttributeEnum.MEDIAN_SALE_PRICE.value in input:
            self._homevalue._median_sale_price = input[AttributeEnum.MEDIAN_LIST_PRICE.value]
        if AttributeEnum.YOY_FORECAST.value in input:
            self._homevalue._one_year_forcast = input[AttributeEnum.YOY_FORECAST.value]
        if AttributeEnum.ZHVI.value in input:
            self._homevalue._zillow_value = input[AttributeEnum.ZHVI.value]
        if AttributeEnum.NEGATIVE_EQUITY.value in input:
            self._homevalue._negative_equity = input[AttributeEnum.NEGATIVE_EQUITY.value]
        if AttributeEnum.DELINQUENCY.value in input:
            self._homevalue._delinquency = input[AttributeEnum.DELINQUENCY.value]
        if AttributeEnum.RENT_LIST_PRICE.value in input:
            self._homevalue._rent_list_price = input[AttributeEnum.RENT_LIST_PRICE.value]
        if AttributeEnum.RENT_PRICE_PER_SQFT.value in input:
            self._homevalue._rent_sqft = input[AttributeEnum.RENT_PRICE_PER_SQFT.value]
        if AttributeEnum.PRICE_SQFT.value in input:
            self._homevalue._price_sqft = input[AttributeEnum.PRICE_SQFT.value]


    def process_market_health(self, process_sections):

        market_health_dict = dict()
        for process_section in process_sections:
            parent = self.page_soup.find("div", {"data-label": process_section}).parent
            for li in parent.findAll("li"):
                value_span = li.find("span", {"class": "value"}, recursive=False)
                key_span = li.find("span", {"class": "info zsg-fineprint"})
                if value_span and key_span:
                    value = value_span.text.strip()
                    key =key_span.find(text=True).strip()
                    print(" key :{}, value:{}".format(key, value))
                    market_health_dict[key] = value
        print("***** dict:{}".format(market_health_dict))
        self.set_market_overview_items(market_health_dict)

    def get_all_nearby_region_href(self):
        neibhouring_href = []
        tables = self.page_soup.findAll("table", {"class": "zsg-table nearby-regions-table"})
        for table in tables:
            anchors = table.findAll("a", {"class": "track-ga-event"})
            for anchor in anchors:
                attributes = anchor.attrs
                neibhouring_href.append(attributes['href'])

        print(neibhouring_href)
        return neibhouring_href

    def write_data_as_json(self, location):

        if not os.path.exists('./data'):
            os.makedirs('./data')

        json = self._homevalue.get_as_json()
        file_name = 'zillowInsight-{location}.json'.format(location=location)
        full_path = "./data/" + file_name
        with open(full_path, "w") as fp:
            fp.write(json)

    def write_data_as_csv(self, location):
        if not os.path.exists('./data'):
            os.makedirs('./data')

        csv_hdr = self._homevalue.get_header_as_csv()
        csv = self._homevalue.get_as_csv()
        file_name = 'zillowInsight-{location}.csv'.format(location=location)
        full_path = "./data/" + file_name
        with open(full_path, "w") as fp:
            fp.write(csv_hdr + "\n")
            fp.write(csv + "\n")



if __name__ == "__main__":
    print(sys.argv)
    if len(sys.argv) < 2:
        raise Exception("Please provide the location to scrap")
    else:
        HomePriceScrapper.scrap_home_values(sys.argv[1])
