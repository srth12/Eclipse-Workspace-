
from bs4 import BeautifulSoup as soup  # HTML data structure
from home_value import HomeValue
from key_enum import AttributeEnum
import requests
import ssl
import urllib.parse
import urllib.request
import re

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
        # homevalue._market_temperature = self._homescrapper.get_market_temperature()
        process_sections = ["Market Overview", "Market Health", "Rentals"]

        [homescrapper.process_market_health(process_section) for process_section in process_sections]
        homescrapper._homevalue.__str__()

    def get_pattern_with_whitespace(self, dirty_string):
        pattern = re.compile(r'\s*%s\s*' % dirty_string)
        return pattern

    def set_page_source(self, page_url, parser_type="html.parser"):

        req = urllib.request.Request(page_url, data, headers)
        with urllib.request.urlopen(req, context=context) as response:

            self.page_soup = soup(response.read(), parser_type)

    def get_yoy_change_and_forecast(self):
        containers = self.page_soup.findAll("li", {"class": "zsg-lg-1-2"})
        change, forecast = "", ""
        for container in containers:
            if container.span.text == '1-year change':
                change = container.text
            else:
                forecast = container.text

        return (change, forecast)

    def get_market_temperature(self):
        containers = self.page_soup.findAll("div", {"class": "zsg-h2"})
        return containers[0].text

    def get_sqft_price(self):
        containers = self.page_soup.findAll("span", {"class": "yui_3_18_1_1_1587802421734_2485"})
        return containers[0].text

    def get_median_listing_price(self):
        containers = self.page_soup.findAll("span", {"class": "yui_3_18_1_1_1587802421734_2495"})
        return containers[0].text

    def get_median_sale_price(self):
        containers = self.page_soup.findAll("span", {"class": "yui_3_18_1_1_1587802421734_2504"})
        return containers[0].text

    def set_market_overview_items(self, input):
        if AttributeEnum.MEDIAN_LIST_PRICE in input:
            self._homevalue._median_listing_price = input[AttributeEnum.MEDIAN_LIST_PRICE]
        if AttributeEnum.MEDIAN_SALE_PRICE in input:
            self._homevalue._median_sale_price = input[AttributeEnum.MEDIAN_LIST_PRICE]
        if AttributeEnum.YOY_FORECAST in input:
            self._homevalue._price_sqft = input[AttributeEnum.YOY_FORECAST]
        if AttributeEnum.ZHVI in input:
            self._homevalue._zillow_value = input[AttributeEnum.ZHVI]
        if AttributeEnum.NEGATIVE_EQUITY in input:
            self._homevalue._negative_equity = input[AttributeEnum.NEGATIVE_EQUITY]
        if AttributeEnum.DELINQUENCY in input:
            self._homevalue._delinquency = input[AttributeEnum.DELINQUENCY]


    def process_market_health(self, process_section):
        parent = self.page_soup.find("div", {"data-label": process_section}).parent
        market_health_dict = dict()
        for li in parent.findAll("li"):
            value_span = li.find("span", {"class": "value"}, recursive=False)
            key_span = li.find("span", {"class": "info zsg-fineprint"})
            if value_span and key_span:
                value = value_span.text.strip()
                key =key_span.find(text=True).strip()
                print(" key :{}, value:{}".format(key, value))
                market_health_dict[key] = value

        self.set_market_overview_items(market_health_dict)



if __name__ == "__main__":
    HomePriceScrapper.get_xyz("sanfrancisco-ca")
