#is tree binary search tree

class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

visited = [False] * (10 ** 4)

def checkBST(root):
    if root == None:
        return True

    is_leaf_bst = checkBST(root.left) and checkBST(root.right)

    if is_leaf_bst and is_all_nodes_less(root.left, root.data) and is_all_nodes_greater(root.right, root.data):
        return True
    else:
        return False


def is_all_nodes_greater(root, k):
    if root == None:
        return True

    if visited[root.data] == True:
        return True

    if root.data <= k:
        visited[root.data] = True
        return False

    return is_all_nodes_greater(root.left, k) and is_all_nodes_greater(root.right, k)

def is_all_nodes_less(root, k):
    if root == None:
        return True

    if visited[root.data] == True:
        return True

    if root.data >= k:
        visited[root.data] = True
        return False

    return is_all_nodes_less(root.left, k) and is_all_nodes_less(root.right, k)


if __name__ == "__main__":
    node1 = node(1)
    node2 = node(2)
    node1.right = node2

    node3 = node(4)
    node2.right = node3

    node4 = node(3)
    node3.right = node4
    res = checkBST(node1)
    print(res)