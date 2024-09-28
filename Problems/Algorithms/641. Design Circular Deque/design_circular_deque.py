#!/usr/bin/env python3

from collections import deque


class MyCircularDeque:

    def __init__(self, k: int):
        self.size = k
        self.deque = deque()
        
    def insertFront(self, value: int) -> bool:
        if len(self.deque) < self.size:
            self.deque.appendleft(value)
            return True

    def insertLast(self, value: int) -> bool:
        if len(self.deque) < self.size:
            self.deque.append(value)
            return True

    def deleteFront(self) -> bool:
        if self.deque:
            self.deque.popleft()
            return True

    def deleteLast(self) -> bool:
        if self.deque:
            self.deque.pop()
            return True

    def getFront(self) -> int:
        if self.deque:
            return self.deque[0]
        return -1

    def getRear(self) -> int:
        if self.deque:
            return self.deque[-1]
        return -1

    def isEmpty(self) -> bool:
        return not self.deque

    def isFull(self) -> bool:
        return len(self.deque) == self.size


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()