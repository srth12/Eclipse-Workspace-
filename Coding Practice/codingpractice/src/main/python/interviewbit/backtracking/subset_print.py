class Subset:

    def permutor(self, result, curr, list_ele):
        if list_ele == []:
            result.append(curr)
            return result
        result.append(curr)
        for i in range(len(list_ele)):
            self.permutor(result, curr + [list_ele[i]], list_ele[i + 1::])

    def subsets(self, A):
        result = []
        A.sort()
        self.permutor(result, [], A)
        print(result)

if __name__ == '__main__':
    s = Subset()
    s.subsets([6])

