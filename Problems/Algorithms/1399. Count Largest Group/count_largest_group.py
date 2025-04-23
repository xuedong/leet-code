#!/usr/bin/env python

from collections import Counter


class Solution:
    def countLargestGroup(self, n: int) -> int:
        map = Counter()
        for i in range(1, n + 1):
            key = sum([int(x) for x in str(i)])
            map[key] += 1

        max_value = max(map.values())
        count = sum(1 for v in map.values() if v == max_value)
        return count
