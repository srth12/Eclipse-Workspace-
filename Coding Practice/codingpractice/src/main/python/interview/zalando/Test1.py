def remove_unwanted_zeros(S):
    result = S
    for element in S:
        if element is '0':
            result = result[1:]
        else:
            break
    return result

def solution(S):
    # write your code in Python 3.6
    S = remove_unwanted_zeros(S)
    if S == '0' or S == '':
        return 0
    num_of_steps_to_zero = 0

    while S != '0':
        if S[-1] == '0':
            S = S[:-1]
            num_of_steps_to_zero += 1
        else:
            S = S[:-1] + '0'
            num_of_steps_to_zero += 1

    return num_of_steps_to_zero


if __name__ == '__main__':
    S = "0"
    # print(S[-1])
    k = solution(S)
    print(k)