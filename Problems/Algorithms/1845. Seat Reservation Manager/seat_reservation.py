#!/usr/bin/env python3

import heapq


class SeatManager:

    def __init__(self, n: int):
        self.seats = [i for i in range(1, n+1)]

    def reserve(self) -> int:
        curr = heapq.heappop(self.seats)
        return curr

    def unreserve(self, number: int) -> None:
        heapq.heappush(self.seats, number)


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)