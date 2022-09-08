#!/usr/bin/env python3

from typing import List


class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)

        ans, total = 0, 0
        for i in range(n):
            ans += i * nums[i]
            total += nums[i]

        curr = ans
        for i in range(n-1, 0, -1):
            curr += total - nums[i]
            curr -= (n-1) * nums[i]
            if curr > ans:
                ans = curr

        return ans
