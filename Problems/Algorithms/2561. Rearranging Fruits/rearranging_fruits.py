#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        freq = Counter()
        cheapest = float("inf")
        for b1 in basket1:
            freq[b1] += 1
            cheapest = min(cheapest, b1)
        for b2 in basket2:
            freq[b2] -= 1
            cheapest = min(cheapest, b2)

        merge = []
        for key, count in freq.items():
            if count % 2 != 0:
                return -1
            merge.extend([key] * (abs(count) // 2))

        if not merge:
            return 0
        merge.sort()
        return sum(min(2 * cheapest, x) for x in merge[:len(merge)//2])
