#!/usr/bin/env python3

from math import comb
from typing import List


class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7

        def dfs(nums):
            n = len(nums)
            if n < 3:
                return 1

            left = [node for node in nums if node < nums[0]]
            right = [node for node in nums if node > nums[0]]

            return dfs(left) * dfs(right) * comb(n-1, len(left)) % mod

        return (dfs(nums) - 1) % mod
