#!/usr/bin/env python3


class Solution:
    def minimumSteps(self, s: str) -> int:
        total, count = 0, 0

        for ch in s:
            if ch == '0':
                total += count
            else:
                count += 1

        return total
