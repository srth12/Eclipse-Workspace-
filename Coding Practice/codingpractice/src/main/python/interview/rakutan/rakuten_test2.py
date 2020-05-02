# Minimum number of tree cuts so that each pair of trees alternates between strictly decreasing and strictly increasing
# url: https://cs.stackexchange.com/questions/116854/minimum-number-of-tree-cuts-so-that-each-pair-of-trees-alternates-between-strict
# key aesthetically pleasing tree problem

def solution(A):
    # write your code in Python 3.6
    if len(A) <= 1:
        return 0
    odd = get_min_tree_cut_required(True, A)
    even = get_min_tree_cut_required(False, A)

    return min(odd, even)

def get_min_tree_cut_required(is_odd_cut, A):
    total_cut = 0
    if is_odd_cut:
        idx = 0
    else:
        idx = 1
    if len(A) % 2 == 1:
        max_idx = len(A) - 1
        if is_odd_cut:
            loop_size = int (len(A)/2 + 1)
        else:
            loop_size = int(len(A)/2)
    else:
        max_idx = len(A) - 2
        loop_size = int (len(A)/2)

    if is_odd_cut:
        idx = 0

    else:
        idx = 1

    for _ in range(loop_size):
        if idx != 0 and idx != max_idx:
            if A[idx] >= A[idx - 1] or A[idx] >= A[idx + 1]:
                total_cut += 1

        elif idx == 0:
            if A[0] >= A[1]:
                total_cut += 1
        elif idx == max_idx:
            if A[idx] >= A[idx - 1]:
                total_cut += 1

        idx += 2

    return total_cut






if __name__ == '__main__':
    # a = [3, 7, 4, 5]
    # a = [5, 4, 3, 2, 6]
    # a = [2, 2, 2, 2]
    a = [2, 2]
    x = solution(a)
    print("Hellow test:{}".format(x))


