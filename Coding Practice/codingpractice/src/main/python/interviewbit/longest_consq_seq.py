class longest_cons_seq:
    # Improvement - DO it with "SET"

    def longestConsecutive(self, A):
        MAX_LEN = 0
        ele_dict = dict()
        [ele_dict.update({k:k}) for k in A]

        x = A[0]
        while x in ele_dict:
            temp_max = 1
            del ele_dict[x]
            i = 1
            while (x + i) in ele_dict:
                del ele_dict[x + i]
                temp_max += 1
                i += 1
            i = 1
            while (x - i) in ele_dict:
                del ele_dict[x - i]
                temp_max += 1
                i += 1

            if MAX_LEN < temp_max:
                MAX_LEN = temp_max

            if ele_dict.__len__() == 0:
                break
            x = ele_dict.popitem()[0]
            ele_dict.update({x:x})
        return MAX_LEN



if __name__ == '__main__':
    l = longest_cons_seq()
    res = l.longestConsecutive([ 21, 114, 49, 74, 48, 107, 54, 66, 18, 93, 64, 50, 92, 39, 37, 70, -2, 117, 72, 40, 87, 35, 79, 52, 44, 4, 38, 84, 25, 113, 106, 32, 27, 57, 68, 45, 96, 36, 108, 17, 86, 2, 118, 9, 29, 100, 5, 13, 58, 101, 97, 105, 77, 78, 43, 20, 24, 94, 111, 53 ])
    print(res)