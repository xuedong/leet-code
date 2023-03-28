#!/usr/bin/env python3

from functools import lru_cache
from typing import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        durations = [1, 7, 30]

        @lru_cache(None)
        def dp(i):
            if i > 365:
                return 0
            elif i in days:
                return min([dp(i+duration) + cost for cost, duration in zip(costs, durations)])
            else:
                return dp(i+1)

        return dp(1)
