'''
Python version of the Singly Linked List with recursion for printing the list in reverse.
'''

class Node:
    def __init__(self, data, next_node=None):
        self.data = data
        self.next = next_node

class MyList:
    def __init__(self):
        self.head = None

    def add_front(self, data):
        self.head = Node(data, self.head)

    def add_back(self, data):
        if self.head is None:
            self.add_front(data)
            return
        tmp = self.head
        while tmp.next is not None:
            tmp = tmp.next
        tmp.next = Node(data)

    def show_list(self):
        print("[", end=" ")
        tmp = self.head
        while tmp is not None:
            print(tmp.data, end=" ")
            tmp = tmp.next
        print("]")

    def show_list_reversed(self):
        print("[", end=" ")
        self._show_rev(self.head)
        print("]")

    def _show_rev(self, h):
        if h.next is not None:
            self._show_rev(h.next)
        print(h.data, end=" ")

    def size(self):
        count = 0
        tmp = self.head
        while tmp is not None:
            count += 1
            tmp = tmp.next
        return count

    def empty(self):
        return self.head is None

    def clear(self):
        self.head = None

if __name__ == "__main__":
    list = MyList()
    list.add_back(4)
    list.add_back(5)
    list.add_front(3)
    list.add_front(2)
    list.add_front(1)
    list.show_list()
    list.show_list_reversed()
    print("size =", list.size())
