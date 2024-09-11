#!/usr/bin/env python3


class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        num = start ^ goal

        count = 0
        while num:
            count += num & 1
            num >>= 1

        return count
