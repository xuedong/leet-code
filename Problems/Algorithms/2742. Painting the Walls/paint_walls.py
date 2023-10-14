#!/usr/bin/env python3

from typing import List
from functools import lru_cache
from math import inf


class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        @lru_cache
        def dp(i, remain):
            if remain <= 0:
                return 0

            if i == n:
                return inf

            return min(cost[i] + dp(i+1, remain-1-time[i]), dp(i+1, remain))

        n = len(cost)
        return dp(0, n)
