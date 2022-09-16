#!/usr/bin/env python3

from functools import lru_cache
from typing import List


class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        n, m = len(nums), len(multipliers)
        if m == 1:
            return max(nums[0] * multipliers[0], nums[-1] * multipliers[0])

        @lru_cache(1000)
        def dp(i, j, k):
            if k == m:
                return 0
            return max(nums[i] * multipliers[k] + dp(i + 1, j, k + 1),
                       nums[j] * multipliers[k] + dp(i, j - 1, k + 1))

        return dp(0, n - 1, 0)
