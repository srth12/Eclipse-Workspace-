# Check if the adjecent cells are same country or not. If same country, id will be same. Only can be moved
# in north, south, west or east. No diagonal movements.


def solution(A):
    # write your code in Python 3.6
    number_of_contires = 0
    is_visited = [[False]*len(A[0]) for _ in A ]
    for row in range(len(A)):
        for column in range(len(A[0])):
            if not is_visited[row][column]:
                contry_id = A[row][column]
                traverse_adjecent_country_borders(A, row, column, is_visited, contry_id)
                number_of_contires += 1

    return number_of_contires



def traverse_adjecent_country_borders(A, row, column, is_visited, contry_id):
    if len(A) <= row or len(A[0]) <= column:
        return
    if row < 0 or column < 0:
        return
    if contry_id == A[row][column] and not is_visited[row][column]:
        is_visited[row][column] = True
        traverse_adjecent_country_borders(A, row +1, column, is_visited, contry_id)
        traverse_adjecent_country_borders(A, row -1, column, is_visited, contry_id)
        traverse_adjecent_country_borders(A, row, column + 1, is_visited, contry_id)
        traverse_adjecent_country_borders(A, row, column - 1, is_visited, contry_id)
    else:
        return

if __name__ == "__main__":
    print(solution([[5, 4, 4], [4, 3, 4], [3, 2, 4], [2, 2, 2], [3, 3, 4], [1, 4, 4], [4, 1, 1]]))
    # print(solution([[1, 1, 1], [1, 1, 1]]))