import math



def solution(S, X, Y):

    if len(S) == 1:
        return 0

    MAX_DISTANCE_ALLOWED = 10 ** 9 + 1
    element_with_length = dict()
    duplicate_with_max_length = dict()
    result = 0

    for idx in range(len(S)):
        len_element = get_distance_of_point(X[idx], Y[idx])

        if S[idx] in element_with_length:
            if S[idx] in duplicate_with_max_length:
                max_len = duplicate_with_max_length[S[idx]]
            else:
                max_len = MAX_DISTANCE_ALLOWED
                duplicate_with_max_length[S[idx]] = MAX_DISTANCE_ALLOWED

            if len_element < max_len:
                duplicate_with_max_length[S[idx]] = len_element
                max_len = len_element

            if MAX_DISTANCE_ALLOWED > max_len:
                MAX_DISTANCE_ALLOWED = max_len

        else:
            element_with_length[S[idx]] = len_element

    for element, len_element in element_with_length.items():
        if len_element < MAX_DISTANCE_ALLOWED:
            result += 1

    return result



def get_distance_of_point(x, y):

    sq_sum = x*x + y*y
    return round(math.sqrt(sq_sum), 2)

if __name__ == "__main__":
    # print(solution('ABB', [1, -2, -2], [1, -2, 2]))
    print(solution('A', [1,], [1, ]))
    print(solution('ABDCA', [2, -1, -4, -3, 3], [2, -2, 4, 1, -3]))

    # print(solution('CCD', [1, -1, 2], [1, -1, -2]))