
def rotLeft(a, d):
    rotate_by = d % len(a)
    if len(a) <=1 or rotate_by == 0:
        return a
    return a[rotate_by:] + a[:rotate_by]


if __name__ == "__main__":
    print(rotLeft([1,2,3,4,5], 3))