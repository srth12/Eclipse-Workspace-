

# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
# return max array with odds are same and evens are same!

def solution(A):
    # write your code in Python 3.6
    if len(A) == 1:
        return 1
    max_array = get_max_switching_array(A)
    return len(max_array)

def get_max_switching_array(A):
    if is_switching(A):
        return A
    right = A[1:]
    left = A[:-1]
    right_array = get_max_switching_array(right)
    left_array = get_max_switching_array(left)
    if len(right_array) > len(left_array):
        return right_array
    else:
        return left_array

def is_switching(A):
    odd_dig = A[0]
    even_dig = A[1]
    for idx in range(len(A)):
        if idx % 2 == 0:
            if odd_dig != A[idx]:
                return False
        else:
            if even_dig != A[idx]:
                return False

    return True






if __name__ == "__main__":
    print(solution([1, 2, 1, 4 ]))