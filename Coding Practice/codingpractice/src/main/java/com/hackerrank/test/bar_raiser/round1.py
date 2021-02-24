# def say_hello():
#     print('Hello, World')

# for i in range(5):
#     say_hello()

def is_sudoku(arr):

    n = len(arr)

    if n < 1:
        return True
    if n == 1 and arr[0][0] == 1:
        return True
    elif n == 1:
        return False

    for row in arr:
        counter_array = [0]*n

        for column in row:
            if column < 1 or column > n:
                return False

            if counter_array[column - 1] > 0:
                return False

            else:
                counter_array[column - 1] = 1

        if n != sum(counter_array):
            return False

    for row_idx in range(n):
        counter_array = [0]*n

        for column_idx in range(n):

            if counter_array[arr[column_idx][row_idx] - 1] > 0:
                return False
            else:
                counter_array[arr[column_idx][row_idx] - 1] = 1


        if n != sum(counter_array):
            return False


    return True

# print(is_sudoku([[1, 2, 3, 4],[1, 2, 3, 4],[1, 2, 3, 4],[1, 2, 3, 4]]))

#print(is_sudoku([[1, 2, 3, 4],[3, 4, 1, 2],[2, 3, 4, 1],[4, 1, 2, 3]]))
# print(is_sudoku([[]]))
# print(is_sudoku([[0]]))

# True
grid0 = [
            [1,2,3],
            [3,1,2],
            [2,3,1]
        ],

# True
grid1 = [
    [1,2,3,4],
    [3,4,1,2],
    [2,3,4,1],
    [4,1,2,3]
];
# False
grid2 = [
    [1,2,3],
    [1,2,3],
    [1,2,3]
];
# False
grid3 = [
    [1,1,1],
    [2,2,2],
    [3,3,3]
];
# False
grid4 = [
    [1000,-1000,6],
    [2,3,1],
    [3,1,2]
];
# False
grid5 = [[0]];

# False
grid6 = [
    [3, 2, 3, 2],
    [2, 3, 2, 3],
    [3, 2, 3, 2],
    [2, 3, 2, 3]
];
# False
grid7 = [
    [2,3,4],
    [3,4,2],
    [4,2,3]
];
# False
grid8 = [
    [-1,-2,-3],
    [-2,-3,-1],
    [-3,-1,-2]
];
# False
grid9 = [
    [1,1,1],
    [1,1,2],
    [1,2,3]
];

grids = [grid0, grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8, grid9]
expected = [True, True, False, False, False, False, False, False, False, False]

# for idx in range(len(grids)):
#     print(idx)
#     print(is_sudoku(grids[idx]))
#     print('----')

print(is_sudoku(grid0))


#
# Your previous Java content is preserved below:
#
# /*
# NxN matrix
# Every cell will contain a integer
#
# Verify that every row as well as every column contains all numbers from 1 to #
#
#
# Example
# ---------
# 1, 2, 3, 4
# 3, 4, 1, 2
# 2, 3, 4, 1
# 4, 1, 2, 3
#
#
# */


