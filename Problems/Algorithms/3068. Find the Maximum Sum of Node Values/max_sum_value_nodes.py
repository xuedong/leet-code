#!/usr/bin/env python3

from typing import List


class Solution:
    def helper(self, index, is_even, nums, k, dp):
        if index == len(nums):
            return 0 if is_even == 1 else -float("inf")
        if dp[index][is_even] != -1:
            return dp[index][is_even]

        no_operation = nums[index] + self.helper(index+1, is_even, nums, k, dp)
        operation = (nums[index]^k) + self.helper(index+1, is_even^1, nums, k, dp)
        dp[index][is_even] = max(no_operation, operation)
        return dp[index][is_even]

    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:
        dp = [[-1] * 2 for _ in range(len(nums))]
        return self.helper(0, 1, nums, k, dp)