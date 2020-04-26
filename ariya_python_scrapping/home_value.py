import json

class HomeValue:

    def __init__(self):
        self._zillow_value = None
        self._one_year_change = None
        self._one_year_forcast = None
        self._market_temperature = None
        self._price_sqft = None
        self._median_listing_price = None
        self._median_sale_price = None
        self._avg_days_on_market = None
        self._negative_equity = None
        self._delinquency = None
        self._rent_list_price = None
        self._rent_sqft = None

    def __str__(self):
        for att in dir(self):
            print(att, getattr(self, att))

    def get_as_json(self):

        return json.dumps(self.__dict__)