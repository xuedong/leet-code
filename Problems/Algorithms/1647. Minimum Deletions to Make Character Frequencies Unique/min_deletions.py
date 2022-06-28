#!/usr/bin/env python3

from collections import Counter


class Solution:
    def minDeletions(self, s: str) -> int:
        counts = list(Counter(s).values())
        counts.sort()
        records = set()

        ans = 0
        for num in reversed(counts):
            while num in records and num > 0:
                num -= 1
                ans += 1
            records.add(num)

        return ans

