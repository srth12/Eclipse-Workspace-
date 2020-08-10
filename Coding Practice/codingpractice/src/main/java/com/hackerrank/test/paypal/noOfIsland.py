'''
# Sample code to perform I/O:

name = input()                  # Reading input from STDIN
print('Hi, %s.' % name)         # Writing output to STDOUT

# Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
'''

# Write your code here

#grid = [
#  ["1","1","1","1","0"],
#  ["1","1","0","1","0"],
#  ["1","1","0","0","0"],
#  ["0","0","0","0","0"]
#]
#
#Output: 1


def findIslands(matrix):
    n = len(matrix)
    noOfIslands = 0

    if n == 0:
        return 0

    isVisited = [[False]*n for _ in matrix]

    for row in range(n):
        for column in range(n):

            if isVisited[row][column] or matrix[row][column] == 0:

                continue
            noOfIslands += 1
            findConnectedLands(matrix, row, column, isVisited, n)

    return noOfIslands

def findConnectedLands(matrix, row, column, isVisited, n):
    if row >= n or row < 0:
        return
    if column >= n or column < 0:
        return

    if matrix[row][column] == 0 or isVisited[row][column]:
        return
    isVisited[row][column] = True

    findConnectedLands(matrix, row + 1, column, isVisited, n)
    findConnectedLands(matrix, row - 1, column, isVisited, n)
    findConnectedLands(matrix, row, column + 1, isVisited, n)
    findConnectedLands(matrix, row, column - 1, isVisited, n)


if __name__ == '__main__':
    print("******* Test *******")
    matrix = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]
    result = findIslands(matrix)
    print("Result is {}".format(result))
