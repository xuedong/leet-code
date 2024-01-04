#!/usr/bin/env python3

from collections import Counter
from typing import List
from math import ceil


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        counts = Counter(nums)

        ans = 0
        for num in counts.values():
            if num == 1:
                return -1
            ans += ceil(num/3)

        return ans
