#!/usr/bin/env python3

from typing import List


class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ans, cur = 0, nums[0]

        for i in range(1, len(nums)):
            if nums[i] <= nums[i-1]:
                ans = max(ans, cur)
                cur = 0
            cur += nums[i]

        return max(ans, cur)