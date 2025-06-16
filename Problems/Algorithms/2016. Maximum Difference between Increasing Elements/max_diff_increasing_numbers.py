#!/usr/bin/env python3

from typing import List


class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        n = len(nums)
        ans, prev = -1, nums[0]

        for i in range(1, n):
            if nums[i] > prev:
                ans = max(ans, nums[i] - prev)
            else:
                prev = nums[i]

        return ans
