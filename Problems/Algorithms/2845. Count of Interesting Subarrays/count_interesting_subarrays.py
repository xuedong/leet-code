#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        count = Counter([0])
        ans = 0
        prefix = 0
        n = len(nums)
        for i in range(n):
            prefix += 1 if nums[i] % modulo == k else 0
            ans += count[(prefix - k + modulo) % modulo]
            count[prefix % modulo] += 1

        return ans
