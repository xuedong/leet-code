#!/usr/bin/env python3

from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        self.total = sum(nums)
        memo = [[float("-inf")] * (2 * self.total + 1) for _ in range(len(nums))]

        return self.compute(nums, 0, 0, target, memo)

    def compute(self, nums: List[int], curr_idx: int, curr_sum: int, target: int, memo: List[List[int]]) -> int:
        if curr_idx == len(nums):
            return 1 if curr_sum == target else 0
        
        if memo[curr_idx][curr_sum + self.total] != float("-inf"):
            return memo[curr_idx][curr_sum + self.total]

        add = self.compute(nums, curr_idx + 1, curr_sum + nums[curr_idx], target, memo)
        sub = self.compute(nums, curr_idx + 1, curr_sum - nums[curr_idx], target, memo)

        memo[curr_idx][curr_sum + self.total] = add + sub
        return memo[curr_idx][curr_sum + self.total]
