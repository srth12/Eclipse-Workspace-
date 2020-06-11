#Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and
# the edge between any two nodes is always of length 6. We define node  to be the starting position for a BFS.
# Given a graph, determine the distances from the start node to each of its descendants and
# return the list in node number order, ascending. If a node is disconnected, it's distance should be .

class Node:
    def __init__(self, data):
        self._data = data
        self._adjecent_nodes = []

    def adjecent_nodes(self):
        return self._adjecent_nodes
    def add_adjecent_node(self, n):
        self._adjecent_nodes.append(n)

class Graph:
    def __init__(self, n):
        self._n = n
        self._node_map = dict()
        self._distance_list = [0] * n

    def connect(self, x:int, y:int):
        node_x = self._node_map.get(x, Node(x))
        node_y = self._node_map.get(y, Node(y))
        node_x.add_adjecent_node(node_y)
        node_y.add_adjecent_node(node_x)
        self._node_map[x] = node_x
        self._node_map[y] = node_y

    def find_all_distances(self, s):

        node_x = self._node_map.get(s, Node(s))
        queue = [node_x]
        visited = [False] * self._n
        visited[s] = True

        while(len(queue) != 0):
            element = queue.pop(0)
            # visited[element._data] = True
            adj_distance = self._distance_list[element._data]
            for adj_ele in element.adjecent_nodes():
                if visited[adj_ele._data]:
                    continue
                visited[adj_ele._data] = True
                self._distance_list[adj_ele._data] = adj_distance + 6
                queue.append(adj_ele)

        result = ""
        for ele in range(0, self._n, 1):
            if ele == s:
                continue
            if self._distance_list[ele] > 0:
                print(self._distance_list[ele], end=" ")
                # result = " ".join([result, str(self._distance_list[ele])])
            else:
                # result = " ".join([result, str(-1)])
                print(-1, end=" ")

        print(result)
        return result


t = int(input())
for i in range(t):
    n,m = [int(value) for value in input().split()]
    graph = Graph(n)
    for i in range(m):
        x,y = [int(x) for x in input().split()]
        graph.connect(x-1,y-1)
    s = int(input())
    graph.find_all_distances(s-1)

