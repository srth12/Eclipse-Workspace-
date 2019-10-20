class Solution:
    # @param A : tuple of integers
    # @return an integer
    def majorityElement(self, A):
        n = len(A)/2
        ele_dict = dict()
        for ele in A:
            if ele in ele_dict:
                count = ele_dict[ele]
                if count + 1 > n:
                    return ele
                ele_dict[ele] = count + 1
            else:
                if 1 > n:
                    return ele
                ele_dict[ele] = 1

if __name__ == '__main__':
    s = Solution()
    res = s.majorityElement([1,1,2])
    print(res)
