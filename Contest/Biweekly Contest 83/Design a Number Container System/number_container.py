#!/usr/bin/env python3

import heapq


class NumberContainers:

    def __init__(self):
        self.pairs = set()
        self.map = {}

    def change(self, index: int, number: int) -> None:
        for pair in self.pairs:
            if index == pair[0]:
                pq, temp = self.map[pair[1]], []
                while pq[0] != index:
                    temp.append(heapq.heappop(pq))
                heapq.heappop(pq)
                for element in temp:
                    heapq.heappush(pq, element)

                self.pairs.remove(pair)
                break

        if number not in self.map:
            self.map[number] = []
            heapq.heappush(self.map[number], index)
        else:
            heapq.heappush(self.map[number], index)

        self.pairs.add((index, number))

    def find(self, number: int) -> int:
        if number in self.map and len(self.map[number]) > 0:
            return self.map[number][0]
        return -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)
