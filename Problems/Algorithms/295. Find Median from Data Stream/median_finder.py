#!/usr/bin/env python3
# coding: utf-8

from sortedcontainers import SortedList


class MedianFinder:

    def __init__(self):
        self.sorted_list = SortedList()

    def addNum(self, num: int) -> None:
        self.sorted_list.add(num)

    def findMedian(self) -> float:
        if len(self.sorted_list) % 2 == 1:
            return self.sorted_list[len(self.sorted_list) // 2]
        return (self.sorted_list[len(self.sorted_list) // 2] + self.sorted_list[len(self.sorted_list) // 2 - 1]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()