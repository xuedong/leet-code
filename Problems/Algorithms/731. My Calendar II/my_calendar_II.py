#!/usr/bin/env python3


class MyCalendarTwo:

    def __init__(self):
        self.bookings = []
        self.overlaps = []
        

    def book(self, start: int, end: int) -> bool:
        for booking in self.overlaps:
            if self.is_overlap(booking[0], booking[1], start, end):
                return False

        for booking in self.bookings:
            if self.is_overlap(booking[0], booking[1], start, end):
                self.overlaps.append(self.get_overlapped(booking[0], booking[1], start, end))

        self.bookings.append((start, end))

        return True

    
    def is_overlap(self, start1: int, end1: int, start2: int, end2: int) -> bool:
        return max(start1, start2) < min(end1, end2)


    def get_overlapped(self, start1: int, end1: int, start2: int, end2: int) -> tuple:
        return max(start1, start2), min(end1, end2)


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)