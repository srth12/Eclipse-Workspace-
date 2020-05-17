
#!/bin/python3

import math
import os
import random
import re
import sys

# Not COMPLETED
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
        if input_str[:idx+1] == input_str[idx + 1: idx + 1 + len(input_str[:idx+1])]:
            sum_of_common_prefix += len(input_str[:idx+1])
        else:
            suffix = input_str[idx + 1: idx + 1 + len(input_str[:idx+1])]
            prefix = input_str[:idx+1]
            if len(prefix) >= len(suffix) and suffix == prefix[:len(suffix) + 1]:
                sum_of_common_prefix += len(suffix)
    return sum_of_common_prefix
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
    print(commonPrefix(["ababaa"]))