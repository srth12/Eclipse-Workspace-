# Rakutan test, find the length of the shortest array possible with the
# array given( shrink the array where the elements are the power of 2)
# and return the size of the array

def solution(A):
    # write your code in Python 3.6
    power_set = set()
    for element in A:
        while element in power_set:
            power_set.remove(element)
            element += 1
        power_set.add(element)

    return len(power_set)



if __name__ == '__main__':
    a = [1, 0, 2, 0, 0, 2]
    x = solution(a)
    print("Hellow test:{}".format(x))