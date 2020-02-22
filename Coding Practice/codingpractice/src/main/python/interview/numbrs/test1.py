#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'budgetShopping' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY bundleQuantities
#  3. INTEGER_ARRAY bundleCosts
# An example of a knapsack problem

def _optimized_bundle_shopping(n, bundleQuantities, bundleCosts, size):
    if size == 0 or size == 0:
        return 0
    if(bundleCosts[size-1] > n):
        return _optimized_bundle_shopping(n, bundleQuantities, bundleCosts, size - 1)
    else:
        option1 = _optimized_bundle_shopping(n, bundleQuantities, bundleCosts, size - 1)
        option2 = bundleQuantities[size - 1] + \
                  _optimized_bundle_shopping(n - bundleCosts[size - 1], bundleQuantities, bundleCosts, size - 1)
        return max(option1, option2)

def budgetShopping(n, bundleQuantities, bundleCosts):
    # Write your code here
    _optimized_bundle_shopping(n, bundleQuantities, bundleCosts, len(bundleCosts))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    bundleQuantities_count = int(input().strip())

    bundleQuantities = []

    for _ in range(bundleQuantities_count):
        bundleQuantities_item = int(input().strip())
        bundleQuantities.append(bundleQuantities_item)

    bundleCosts_count = int(input().strip())

    bundleCosts = []

    for _ in range(bundleCosts_count):
        bundleCosts_item = int(input().strip())
        bundleCosts.append(bundleCosts_item)

    result = budgetShopping(n, bundleQuantities, bundleCosts)

    fptr.write(str(result) + '\n')

    fptr.close()
