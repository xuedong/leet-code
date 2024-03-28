#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        ans = 0

        i = -1
        freq = Counter()
        for j in range(len(nums)):
            freq[nums[j]] += 1
            while freq[nums[j]] > k:
                i += 1
                freq[nums[i]] -= 1
            ans = max(ans, j-i)

        return ans
