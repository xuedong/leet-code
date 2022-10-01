#!/usr/bin/env python3

from functools import lru_cache


class Solution:
    def numDecodings(self, s: str) -> int:
        @lru_cache(maxsize=None)
        def helper(s):
            if not s:
                return 1
            if s[0] == '0':
                return 0
            if len(s) == 1:
                return 1
            if int(s[:2]) <= 26:
                return helper(s[1:]) + helper(s[2:])
            return helper(s[1:])
        return helper(s)
