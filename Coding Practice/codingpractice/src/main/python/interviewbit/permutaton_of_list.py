class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    result = list()

    def permute(self, A):
        res = []
        self.mix(res, [], A)
        return res

    def mix(self, res, curr, A):
        if A == []:
            res.append(curr)
            return res
        for i in range(len(A)):
            self.mix(res, curr + [A[i]], A[:i]+ A[i+1:])
        return None


if __name__ == '__main__':
    s = Solution()
    result = s.permute([1, 2 , 3])
    print(result)
    if [1,2 ,3 ,4] in [[1,2 ,3 ,4]]:
        print("true")
    else:
        print("false")