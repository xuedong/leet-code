#!/usr/bin/env python3
# coding: utf-8

from functools import lru_cache
from math import log10
from typing import List, Tuple


class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @lru_cache(None)
        def dp(i, prev, count, k):
            if k < 0:
                return float('inf')
            if i == len(s):
                return 0
            res = dp(i + 1, prev, count, k - 1)
            if s[i] == prev:
                res = min(res, dp(i + 1, prev, count + 1, k) + self.get_length(count + 1) - self.get_length(count))
            else:
                res = min(res, dp(i + 1, s[i], 1, k) + 1)
            return res
        return dp(0, '', 0, k)

    def get_length(self, count: int) -> int:
        if count == 1:
            return 1
        elif count <= 9:
            return 2
        elif count <= 99:
            return 3
        return 4
