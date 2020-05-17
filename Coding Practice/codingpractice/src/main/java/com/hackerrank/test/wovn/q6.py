

#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'priceCheck' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING_ARRAY products
#  2. FLOAT_ARRAY productPrices
#  3. STRING_ARRAY productSold
#  4. FLOAT_ARRAY soldPrice
#

def priceCheck(products, productPrices, productSold, soldPrice):
    product_price_map = dict()
    incorrect_count = 0
    for idx in range(len(products)):
        product_price_map[products[idx]] = productPrices[idx]

    for idx in range(len(productSold)):
        product_name = productSold[idx]
        sold_price = soldPrice[idx]
        if sold_price != product_price_map[product_name]:
            incorrect_count += 1

    return incorrect_count


# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')
#
#     products_count = int(input().strip())
#
#     products = []
#
#     for _ in range(products_count):
#         products_item = input()
#         products.append(products_item)
#
#     productPrices_count = int(input().strip())
#
#     productPrices = []
#
#     for _ in range(productPrices_count):
#         productPrices_item = float(input().strip())
#         productPrices.append(productPrices_item)
#
#     productSold_count = int(input().strip())
#
#     productSold = []
#
#     for _ in range(productSold_count):
#         productSold_item = input()
#         productSold.append(productSold_item)
#
#     soldPrice_count = int(input().strip())
#
#     soldPrice = []
#
#     for _ in range(soldPrice_count):
#         soldPrice_item = float(input().strip())
#         soldPrice.append(soldPrice_item)
#
#     result = priceCheck(products, productPrices, productSold, soldPrice)
#
#     fptr.write(str(result) + '\n')
#
#     fptr.close()


if __name__ == "__main__":
    pass