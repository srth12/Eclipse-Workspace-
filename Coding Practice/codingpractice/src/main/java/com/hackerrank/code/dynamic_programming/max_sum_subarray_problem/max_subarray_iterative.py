
#Time complexity O(n)
def max_subset_sum(array):
    length = len(array)
    p = list()
    p.append(array[0])
    p.append( max(array[0], array[1]))

    for i in range(2, length):
        p.append( max(p[i-1], p[i-2], p[i-2] + array[i], array[i]))
    print(p)
    return p.pop(length - 1)


if __name__ == "__main__":
    k = max_subset_sum([3, 7, 4, 6, 5])
    print(k)