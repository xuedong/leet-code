#!/usr/bin/env python3

from functools import lru_cache
from typing import List
from math import inf


class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        dp = {}

        @lru_cache
        def helper(idx, d, maximum):
            if (idx, d, maximum) in dp:
                return dp[(idx, d, maximum)]
            if idx == len(jobDifficulty) and d == 0:
                return maximum
            if idx == len(jobDifficulty) or d == 0:
                return float(inf)

            maximum = max(maximum, jobDifficulty[idx])
            ans = min(helper(idx+1, d, maximum), maximum + helper(idx+1, d-1, 0))
            dp[(idx, d, maximum)] = ans
            return ans

        ans = helper(0, d, 0)
        return ans if ans != float(inf) else -1
