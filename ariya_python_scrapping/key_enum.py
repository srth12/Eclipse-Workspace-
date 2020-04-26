from enum import Enum

class AttributeEnum(Enum):
    MEDIAN_LIST_PRICE = "Median listing price"
    MEDIAN_SALE_PRICE = "Median sale price"
    YOY_FORECAST = "1-yr forecast"
    ZHVI = "ZHVI"
    NEGATIVE_EQUITY = "Homes with negative equity"
    DELINQUENCY = "Delinquent on mortgage"
    RENT_LIST_PRICE = "Rent list price"
    RENT_PRICE_PER_SQFT = "Rent list price / sq ft"
    PRICE_SQFT = "Median list price / sq ft"