
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the 'commonPrefix' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts STRING_ARRAY inputs as parameter.
#

def commonPrefix(inputs):
    result = list()
    for input in inputs:
        result.append(computeCommonPrefix(input))
    return result

def computeCommonPrefix(input_str):
    sum_of_common_prefix = len(input_str)

    for idx in range(len(input_str) - 1):
        prefix = input_str[:idx+1]
        suffix = input_str[idx + 1: idx + 1 + len(input_str[:idx+1])]
        sum_of_common_prefix += commonPrefixUtil(prefix, suffix)

    return sum_of_common_prefix

def commonPrefixUtil(prefix, suffix):
    min_len = min(len(prefix), len(suffix))
    common_prefix_len = 0
    for idx in range(min_len):
        if prefix[:idx+1] == suffix[:idx+1]:
            common_prefix_len = idx + 1
        else:
            break

    return common_prefix_len
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')
#
#     inputs_count = int(input().strip())
#
#     inputs = []
#
#     for _ in range(inputs_count):
#         inputs_item = input()
#         inputs.append(inputs_item)
#
#     result = commonPrefix(inputs)
#
#     fptr.write('\n'.join(map(str, result)))
#     fptr.write('\n')
#
#     fptr.close()

if __name__ == "__main__":
    print(commonPrefix(["abcabc"]))