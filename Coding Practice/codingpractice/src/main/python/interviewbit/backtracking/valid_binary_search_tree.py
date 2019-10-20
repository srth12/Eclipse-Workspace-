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

    def is_left_subtree_lesser(self, x, node):
        if node == None:
            return True
        if node.val < x:
            return self.is_left_subtree_lesser(x, node.left) and self.is_left_subtree_lesser(x, node.right)
        else:
            return False

    def is_right_subtree_greater(self, x, node):
        if node == None:
            return True
        if node.val > x:
            return self.is_right_subtree_greater(x, node.left) and self.is_right_subtree_greater(x, node.right)
        else:
            return False

    def isValidBST_helper(self, A):
        if A == None or A.val == -1:
            return True

        left_bool, right_bool = True, True
        if A.left and A.left.val > A.val:
            return False
        if A.right and A.right.val < A.val:
            return False

        return self.is_left_subtree_lesser(A.val, A.left) and\
               self.is_right_subtree_greater(A.val, A.right) and\
               self.isValidBST_helper(A.left) and self.isValidBST_helper(A.right)

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