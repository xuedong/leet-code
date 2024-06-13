#!/usr/bin/env python3

from typing import List


class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        students.sort()
        seats.sort()
        
        ans = 0
        for i in range(0, len(seats)):
            ans += abs(seats[i] - students[i])
        return ans
