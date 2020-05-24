# Sort the log files according to the lexical order if the elements except the idex elements are string
# else if the elemetns are numeric don't sort and put it at the end.
# link to similar problem: https://leetcode.com/articles/reorder-log-files/

class Solution(object):
    def reorderLogFiles(self, logs):
        def f(log):
            id_, rest = log.split(" ", 1)
            return (0, rest, id_) if rest[0].isalpha() else (1,)

        return sorted(logs, key = f)


if __name__ == "__main__":
    print(test())