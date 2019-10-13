def factorial(x):
    if x == 1:
        return 1
    return x * factorial(x - 1)

class Node:
    def __init__(self, x):
        self._x = x
        self._next_node = None

    @property
    def next_node(self):
        return self._next_node

    @next_node.setter
    def next_node(self, val):
        self._next_node = val
head = None
def reverse_node(node):
    '''

    :param node:
    :return:
    '''
    if node.next_node == None:
        return node
    last_node = reverse_node(node.next_node)
    last_node.next_node = node
    node.next_node = None
    return node

def print_list(n):
    if n == None:
        print("n is none")
        return
    print(n._x)
    print_list(n.next_node)

if __name__ == '__main__':
    print(factorial(10))

    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)
    n1.next_node = n2
    n2.next_node = n3
    n3.next_node = n4
    n4.next_node = n5

    reversed_node = reverse_node(n1)
    print_list(n5)