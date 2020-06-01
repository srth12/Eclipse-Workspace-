from queue import PriorityQueue

class DualPriorityQueue(PriorityQueue):
    def __init__(self, maxPQ=False):
        PriorityQueue.__init__(self)
        self.reverse = -1 if maxPQ else 1

    def put(self, priority, data):
        PriorityQueue.put(self, (self.reverse * priority, data))

    def get(self, *args, **kwargs):
        priority, data = PriorityQueue.get(self, *args, **kwargs)
        return self.reverse * priority, data


if __name__ == "__main__":

    q = DualPriorityQueue(True)

    q.put(3, "")
    q.put(5, "")
    q.put(4, "")

    while not q.empty():
        print(q.get())