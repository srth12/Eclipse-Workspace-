# You are given pointer to the root of the binary search tree and two values  and .
# You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.

class Node:
    def __init__(self, info):
        self.info = info #value of the current node
        self.left = None
        self.right = None
        self.level = None

    def __str__(self):
        return str(self.info)

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def create(self, val):
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root

            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break

# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''

def lca_optimised(root, v1, v2):
    # Time complecity: O(logn)
    if root == None:
        return
    if v1 <= root.info <= v2:
        return root
    elif v1 < root.info and v2 <root.info:
        return lca_optimised(root.left, v1, v2)
    else:
        return lca_optimised(root.right, v1, v2)

def lca(root, v1, v2):
    stack_v1 = []
    stack_v2 = []
    util(root, v1, stack_v1)
    util(root, v2, stack_v2)
    min_size = min(len(stack_v1), len(stack_v2))
    stack_v1 = stack_v1[:min_size]
    stack_v2 = stack_v2[:min_size]

    for i in range(min_size -1, -1, -1):
        t1 = stack_v1.pop()
        t2 = stack_v2.pop()
        if  t1.info == t2.info:
            return t1


def util(root, v, stack):
    if root.info == v:
        stack.append(root)
        return True
    elif root.info > v:
        stack.append(root)
        found = util(root.left, v, stack)
        if not found:
            stack.pop()
        return found
    else:
        stack.append(root)
        found = util(root.right, v, stack)
        if not  found:
            stack.pop()
        return found

if __name__ == "__main__":

    tree = BinarySearchTree()
    # [tree.create(val) for val in [4, 2, 3, 1, 7, 6]]
    [tree.create(val) for val in [1,2]]
    k = lca_optimised(tree.root, 1, 2)
    print(k)