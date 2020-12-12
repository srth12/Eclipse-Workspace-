#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'perfectSubstring' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER k
#
#WORKING CODE


def freq_check(k, string_elements):

    for element in string_elements:
        if element != 0 and element != k:
            return False
    return True

def perfectSubstring(s, k):
    # Write your code here
    perfect_substring_count = 0
    for i in range(0, len(s)):
        char_freq_arry = [0]* 10
        for j in range(i, len(s)):

            char_freq_arry[int(s[j])] += 1
            if char_freq_arry[int(s[j])] > k:
                break

            if char_freq_arry[int(s[j])] == k and freq_check(k, char_freq_arry):
                perfect_substring_count += 1

    return perfect_substring_count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    k = int(input().strip())

    result = perfectSubstring(s, k)

    fptr.write(str(result) + '\n')

    fptr.close()
