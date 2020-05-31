# Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
# All the children sit in a line and each of them has a rating score according to his or her performance in the class.
# Alice wants to give at least 1 candy to each child. If two children sit next to each other,
# then the one with the higher rating must get more candies.
# Alice wants to minimize the total number of candies she must buy.
# https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the candies function below.
INF = 10**9 # a number larger than all ratings

def candies(n, arr):
    arr = [INF] + arr + [INF]
    candy = [0] * (n+1)

    #valley
    for i in range(1, n + 1):
        if arr[i -1] >= arr[i] <= arr[i + 1]:
            candy[i] = 1

    #raise
    for i in range(1, n + 1):
        if arr[i -1] < arr[i] <= arr[i + 1]:
            candy[i] = candy[i - 1] + 1

    #fall
    for i in range(n, 0, -1):
        if arr[i -1] >= arr[i] > arr[i + 1]:
            candy[i] = candy[i + 1] + 1

    #tall
    for i in range(1, n):
        if arr[i -1] < arr[i] > arr[i + 1]:
            candy[i] = max(candy[i -1], candy[i + 1]) + 1

    print(candy)
    return sum(candy)

if __name__ == '__main__':

    k = candies(8, [2, 4, 3, 5, 2, 6, 4, 5])
    print(k)
