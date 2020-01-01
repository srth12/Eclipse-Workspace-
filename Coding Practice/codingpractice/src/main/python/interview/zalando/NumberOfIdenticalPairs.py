# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def number_of_combinations(n):
    if n == 1 or n == 0:
        return 0
    else:
        return int(n * (n-1) / 2)

def solution(A):
    # write your code in Python 3.6
    copy_dict = dict()
    result = 0
    for element in A:
        if element in copy_dict:
            no_of_duplicates = copy_dict[element]
            copy_dict.update({element: no_of_duplicates + 1})
        else:
            copy_dict.update({element: 1})

    for element, no_of_duplicates in copy_dict.items():
        result += number_of_combinations(no_of_duplicates)
        limit = 1000000000
        if result > limit:
            result = limit
            break

    return result

if __name__ == '__main__':
    S = [1, 2, 3]
    # print(S[-1])
    k = solution(S)
    print(k)