#!/usr/bin/env python3

from sortedcontainers import SortedList


class NumberContainers:

    def __init__(self):
        self.pairs = {}
        self.map = {}

    def change(self, index: int, number: int) -> None:
        if index in self.pairs:
            self.map[self.pairs[index]].discard(index)
            self.pairs[index] = number

        if number not in self.map:
            self.map[number] = SortedList()
        self.map[number].add(index)

        self.pairs[index] = number

    def find(self, number: int) -> int:
        if number in self.map and len(self.map[number]) > 0:
            return self.map[number][0]
        return -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)
