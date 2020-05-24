
def test(arr, int):
    count = 0
    for ele in arr:
        if ele == int:
            count += 1

    return count


if __name__ == "__main__":
    print(test([2,3,4,3], 3))