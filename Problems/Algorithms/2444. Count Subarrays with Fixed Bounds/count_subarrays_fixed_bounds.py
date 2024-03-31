#!/usr/bin/env python3

from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans = 0
        bad, left, right = -1, -1, -1
        for i, num in enumerate(nums):
            if not minK <= num <= maxK:
                bad = i
            if num == minK:
                left = i
            if num == maxK:
                right = i

            ans += max(0, min(left, right) - bad)

        return ans
