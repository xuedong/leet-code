#!/usr/bin/env python3

from collections import Counter
from typing import List


class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        counts = Counter(nums)
        ans = 0
        for value in counts.values():
            ans += value * (value - 1) // 2
        return ans
