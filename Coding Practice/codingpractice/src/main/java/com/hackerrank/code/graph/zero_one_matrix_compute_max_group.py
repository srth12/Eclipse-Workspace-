#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxRegion function below.
def maxRegion(grid):
    row_size = len(grid)
    column_size = len(grid[0])
    max_region = 0

    visited = [[False]*column_size for _ in range(row_size)]

    for row in range(row_size):
        for column in range(column_size):
            if visited[row][column]:
                continue
            current_max_reg = traverse_util(grid, row, column, visited, 0, row_size, column_size)
            if current_max_reg > max_region:
                max_region = current_max_reg

    return max_region

def traverse_util(grid, row, column, visited, current_max, max_row_size, max_col_size):
    if not (0 <= row < max_row_size):
        return current_max
    if not (0 <= column < max_col_size):
        return current_max
    if visited[row][column]:
        return current_max

    visited[row][column] = True

    if (grid[row][column] == 1):
        current_max += 1
        max1 = traverse_util(grid, row+1, column, visited, 0, max_row_size, max_col_size)
        max2 = traverse_util(grid, row, column+1, visited, 0, max_row_size, max_col_size)
        max3 = traverse_util(grid, row-1, column, visited, 0, max_row_size, max_col_size)
        max4 = traverse_util(grid, row, column-1, visited, 0, max_row_size, max_col_size)

        max5 = traverse_util(grid, row+1, column+1, visited, 0, max_row_size, max_col_size)
        max6 = traverse_util(grid, row-1, column-1, visited, 0, max_row_size, max_col_size)
        max7 = traverse_util(grid, row+1, column-1, visited, 0, max_row_size, max_col_size)
        max8 = traverse_util(grid, row-1, column+1, visited, 0, max_row_size, max_col_size)

        current_max += max1+max2+max3+max4+max5+max6+max7+max8
        return current_max
    else:
        return current_max



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    m = int(input())

    grid = []

    for _ in range(n):
        grid.append(list(map(int, input().rstrip().split())))

    res = maxRegion(grid)

    fptr.write(str(res) + '\n')

    fptr.close()
