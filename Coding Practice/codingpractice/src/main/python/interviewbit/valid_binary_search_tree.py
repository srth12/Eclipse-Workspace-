# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
       self.val = x
       self.left = None
       self.right = None

class Solution:
    # @param A : root node of tree
    # @return an integer

    def isValidBST(self, A):
        if self.isValidBST_helper(A):
            return 1
        else:
            return 0

    def isValidBST_helper(self, A):
        if A == None or A.val == -1:
            return True

        left_bool, right_bool = True, True
        if A.left:
            if A.left.val < A.val:
                left_bool = self.isValidBST_helper(A.left)
            else:
                return False
        if left_bool and A.right:
            if A.right.val > A.val:
                right_bool = self.isValidBST_helper(A.right)
            else:
                return False

        return left_bool and right_bool


if __name__ == '__main__':
    t1 = TreeNode(11)
    t2 = TreeNode(4)
    t3 = TreeNode(2)
    t4 = TreeNode(5)
    t5 = TreeNode(1)
    t6 = TreeNode(5)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    s = Solution()
    res = s.isValidBST(t1)
    print(res)