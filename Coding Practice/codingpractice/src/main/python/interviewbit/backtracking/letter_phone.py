class Solution:
    # @param A : string
    # @return a list of strings
    def letterCombinations(self, A):
        result = list()
        # input = [[1], ['a', 'b', 'c'], ['d', 'e', 'f']]
        input = self.map_digit_to_letters(A)
        self.helper_method(result, [], input)
        return result

    def map_digit_to_letters(self, A):
        keypad = {
            '0': '0',
            '1': '1',
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        input_2d = list()
        for letter in A:
            val = [char for char in keypad[letter]]
            input_2d.append(val)

        return input_2d

    def helper_method(self, result, curr, rest):
        if(len(rest) == 0):
            tmp_result = ''
            for letter in curr:
                tmp_result += letter
            result.append(tmp_result)
            return result

        sublist = rest.pop(0)
        for ele in sublist:
            self.helper_method(result, curr + [ele], list(rest))


if __name__ == '__main__':
    s = Solution()
    res = s.letterCombinations('2')
    print(res)