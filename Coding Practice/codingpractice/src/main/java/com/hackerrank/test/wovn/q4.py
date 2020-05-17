


#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'paste' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING_ARRAY arr as parameter.
#

def paste(arr):
    result = ""
    # for line in arr:
    result = ";".join(arr)

    print(result)
# Write your code here


# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')
#
#     arr_count = int(input().strip())
#
#     arr = []
#
#     for _ in range(arr_count):
#         arr_item = input()
#         arr.append(arr_item)
#
#     result = paste(arr)
#
#     fptr.write(result + '\n')
#
#     fptr.close()



if __name__ == "__main__":
    paste(["A,", "b", "c"])