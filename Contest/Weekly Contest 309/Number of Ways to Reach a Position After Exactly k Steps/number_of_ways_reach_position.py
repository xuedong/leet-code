#!/usr/bin/env python3

from functools import lru_cache


class Solution:
    def numberOfWays(self, startPos: int, endPos: int, k: int) -> int:
        MOD = 10**9+7

        @lru_cache(maxsize=None)
        def dp_memo(pos, k):
            if k == 0:
                if pos == endPos:
                    return 1
                return 0

            ans = 0
            ans = (ans + dp_memo(pos - 1, k - 1)) % MOD
            ans = (ans + dp_memo(pos + 1, k - 1)) % MOD
            return ans

        return (dp_memo(startPos, k) % MOD)
