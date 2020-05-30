#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxSubsetSum function below. subarray should be non consequitive
#Time complexity O(2^n)
def maxSubsetSum(arr):
    max_value = [None for _ in arr]
    if len(arr) == 0:
        return
    return max_sum_subarray_util(arr, 0, len(arr), max_value), max_value

def max_sum_subarray_util(arr, idx, length, max_value):
    if idx >= length:
        return None

    if max_value[idx] != None:
        return max_value[idx]

    sum_with_ele = max_sum_subarray_util(arr, idx + 2, length, max_value)

    sum_without_ele = max_sum_subarray_util(arr, idx + 1, length, max_value)

    if sum_without_ele is None:
        if sum_with_ele is None:
            max_value[idx] = arr[idx]
    else:
        if sum_with_ele:
            sum_with_ele = sum_with_ele + arr[idx]
        else:
            sum_with_ele = arr[idx]
        max_value[idx] = max(sum_with_ele, sum_without_ele)
    return max_value[idx]


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')
    #
    # n = int(input())
    #
    # arr = list(map(int, input().rstrip().split()))
    #
    # res = maxSubsetSum(arr)
    #
    # fptr.write(str(res) + '\n')
    #
    # fptr.close()
    with open('max_sum_subarray.txt', 'r') as fd:
        list = list(map(int, fd.read().strip().split(",")))
        k, max_value = maxSubsetSum(list)
        print(k)

    # k, max_value = maxSubsetSum([3, 7, 4, 6, 5])
    # # k, max_value = maxSubsetSum([-1, -2, 0])
    #
    # print(k)
    # print(max_value)