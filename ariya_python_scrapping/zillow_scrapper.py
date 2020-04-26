
from bs4 import BeautifulSoup as soup  # HTML data structure
from home_value import HomeValue
from key_enum import AttributeEnum
import ssl
import urllib.parse
import urllib.request
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



class HomeValueScrapper:
    '''
    The Home value scrapped of the website zillow
    '''

    def __init__(self):

        self._url_template = "https://www.zillow.com/{location}/home-values/"
        self._base_url = "https://www.zillow.com"

        self.context = ssl._create_unverified_context()

        self._homevalue = HomeValue()

    @staticmethod
    def scrap_home_values(location):
        '''
        An application user should use this method to scrap and store the
        scrapped data
        :param location: location to be scrapped
        :return: None
        '''

        homescrapper = HomeValueScrapper()
        url = homescrapper._url_template.format(location=location)
        homescrapper.set_page_source(url)
        homescrapper.scrap_and_dump_data(location)
        nearby_hrefs = homescrapper.get_all_nearby_region_href()
        for href in nearby_hrefs:
            nearby_homescrapper = HomeValueScrapper()
            nearby_url = nearby_homescrapper._base_url + href
            nearby_homescrapper.set_page_source(nearby_url)
            location = href.split("/")
            nearby_homescrapper.scrap_and_dump_data(location[1])


    def scrap_and_dump_data(self, location):
        '''
        Scrap and dump the data to the location provided
        :param location: str: location of data scrapping
        :return:  None
        '''
        print("Started scrapping and storing of " + location)
        self.set_market_temperature()
        process_sections = ["Market Overview", "Market Health", "Rentals", "Listings and Sales"]
        self.set_yoy_change()

        self.process_sections_of_home_value(process_sections)

        self.write_data_as_json(location)
        self.write_data_as_csv(location)
        print("Finished scrapping and storing of " + location)


    def set_page_source(self, page_url, parser_type="html.parser"):
        '''
        Sets the exact page url to be scrapped
        :param page_url: exact url of the webpage to be scrapped
        :param parser_type: the type of data we are scrapping (Default: HTML)
        :return: None
        '''

        req = urllib.request.Request(page_url, data, headers)
        with urllib.request.urlopen(req, context=context) as response:

            self.page_soup = soup(response.read(), parser_type)

    def set_yoy_change(self):
        '''
        Sets the Last year change to the HomeValue object
        :return: None
        '''
        forecast_chart_hdr = self.page_soup.find("header", {"class": "forecast-chart-hdr"})
        containers = forecast_chart_hdr.findAll("li", {"class": "zsg-lg-1-2"})
        for container in containers:
            if container.span.text == '1-year change':
                change_perc = container.contents[0]
                self._homevalue._one_year_change= change_perc

    def set_market_temperature(self):
        '''
        Sets the market temperature from the location to the HomeValue obj
        :return: None
        '''
        containers = self.page_soup.findAll("div", {"class": "zsg-h2"})
        if len(containers) > 0:
            self._homevalue._market_temperature = containers[0].text


    def set_market_overview_items(self, input):
        '''
        This is where we will store the processed values
        :param input: dict of all the retrieved fields to be stored
        :return: None
        '''
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


    def process_sections_of_home_value(self, process_sections):
        '''
        This is a generic method which will retrieve all the grouped sections
        from webpage and store it in the internal object of HomeValue
        :param process_sections: List of str of all the sections to be processed
        :return: None
        '''

        market_health_dict = dict()
        for process_section in process_sections:
            parent = self.page_soup.find("div", {"data-label": process_section}).parent
            for li in parent.findAll("li"):
                value_span = li.find("span", {"class": "value"}, recursive=False)
                key_span = li.find("span", {"class": "info zsg-fineprint"})
                if value_span and key_span:
                    value = value_span.text.strip()
                    key =key_span.find(text=True).strip()
                    market_health_dict[key] = value
        self.set_market_overview_items(market_health_dict)

    def get_all_nearby_region_href(self):
        '''
        This method will return all the neighbouring cities scrapper location link
        :return: List of Strings which contains the relative path of home-values
        '''
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
        '''
        The method will dump the data processed as .json file
        :param location: Type: String. Location of the scrapped page
        :return:
        '''

        if not os.path.exists('./data'):
            os.makedirs('./data')

        json = self._homevalue.get_as_json()
        file_name = 'zillowInsight-{location}.json'.format(location=location)
        full_path = "./data/" + file_name
        with open(full_path, "w") as fp:
            fp.write(json)

    def write_data_as_csv(self, location):
        '''
        The method will dump the data processed as .csv file
        :param location: Type: String. Location of the scrapped page
        :return:
        '''
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
        HomeValueScrapper.scrap_home_values(sys.argv[1])
