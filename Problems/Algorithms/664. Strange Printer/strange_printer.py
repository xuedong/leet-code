#!/usr/bin/env python3

import itertools


class Solution:
    def strangePrinter(self, s: str) -> int:
        s = "".join(char for char, _ in itertools.groupby(s))

        dp = {}

        def helper(start, end):
            if start > end:
                return 0

            if (start, end) in dp:
                return dp[(start, end)]

            turns = 1 + helper(start+1, end)
            for k in range(start+1, end+1):
                if s[k] == s[start]:
                    new_turns = helper(start, k-1) + helper(k+1, end)
                    turns = min(turns, new_turns)

            dp[(start, end)] = turns
            return turns

        return helper(0, len(s)-1)
