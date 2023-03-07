#!/usr/bin/env python3

from typing import List


class Solution:
    def is_enough(self, time: List[int], total_time: int, total_trips: int) -> bool:
        trips = 0
        for curr_time in time:
            trips += total_time // curr_time
        return trips >= total_trips

    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        left, right = 0, max(time) * totalTrips + 1
        
        while right - left > 1:
            mid = left + (right - left) // 2
            if self.is_enough(time, mid, totalTrips):
                right = mid
            else:
                left = mid
        
        return right
