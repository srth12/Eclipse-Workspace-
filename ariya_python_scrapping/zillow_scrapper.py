
from bs4 import BeautifulSoup as soup  # HTML data structure
from home_value import HomeValue
from key_enum import AttributeEnum
import requests
import ssl
import urllib.parse
import urllib.request
import re
import os

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
        # https://www.zillow.com/sanfrancisco-ca/home-values/

        self._url_template = "https://www.zillow.com/{location}/home-values/"

        self.context = ssl._create_unverified_context()

        self._homevalue = HomeValue()

    @staticmethod
    def get_xyz(location):

        homescrapper = HomePriceScrapper()
        url = homescrapper._url_template.format(location=location)
        print(url)
        homescrapper.set_page_source(url)
        # print(homescrapper.page_soup)
        print("***************** url proint complete ***********")
        # homevalue._one_year_change = yoy[0]
        # homevalue._one_year_forcast = yoy[1]
        print("***************** try 1 complete ***********")
        homescrapper.get_market_temperature()
        process_sections = ["Market Overview", "Market Health", "Rentals", "Listings and Sales"]
        homescrapper.get_yoy_change()

        homescrapper.process_market_health(process_sections)
        homescrapper.get_all_nearby_region_href()
        homescrapper.write_data_as_json(location)
        # homescrapper._homevalue.__str__()

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
        self._homevalue._market_temperature = containers[0].text
        return containers[0].text

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
        with open("./data/demofile.txt", "w") as fp:
            fp.write(json)



if __name__ == "__main__":
    HomePriceScrapper.get_xyz("sanfrancisco-ca")
