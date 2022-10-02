#!/usr/bin/env python3

from functools import lru_cache


class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        @lru_cache(None)
        def dp(n, target):
            if n == 0:
                return int(target == 0)
            if target < n or target > n * k:
                return 0
            return sum(dp(n - 1, target - i) for i in range(1, k + 1))

        return dp(n, target) % (10 ** 9 + 7)
