#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        dp = [{} for _ in range(len(nums))]
        count = 0
        for i in range(len(nums)):
            for j in range(i):
                diff = nums[i] - nums[j]
                dp[i][diff] = dp[i].get(diff, 0) + dp[j].get(diff, 0) + 1
                count += dp[j].get(diff, 0)
        return count
