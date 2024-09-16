#!/usr/bin/env python3

from typing import List


class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        mins = [int(time[:2]) * 60 + int(time[3:]) for time in timePoints]
        mins.sort()

        ans = min(mins[i+1] - mins[i] for i in range(len(mins) - 1))
        return min(ans, 24 * 60 - mins[-1] + mins[0])
