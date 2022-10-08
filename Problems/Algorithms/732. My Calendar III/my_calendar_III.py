#!/usr/bin/env python3
# coding: utf-8

from sortedcontainers import SortedDict


class MyCalendarThree:

    def __init__(self):
        self.calendar = SortedDict()

    def book(self, start: int, end: int) -> int:
        self.calendar[start] = self.calendar.get(start, 0) + 1
        self.calendar[end] = self.calendar.get(end, 0) - 1
        active = 0
        k = 0
        for v in self.calendar.values():
            active += v
            k = max(k, active)
        return k
        


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(start,end)