#!/usr/bin/env python3

import math
from typing import List


class Solution:
    def helper(self, nums: List[int], mask: int, pairs: int, dp: List[int]) -> int:
        n = len(nums)
        if 2 * pairs == n:
            return 0

        if dp[mask] != -1:
            return dp[mask]

        score = 0
        for i in range(n):
            for j in range(i+1, n):
                if (mask >> i) & 1 == 1 or (mask >> j) & 1 == 1:
                    continue
                
                new_mask = mask | (1 << i) | (1 << j)
                curr = (pairs + 1) * math.gcd(nums[i], nums[j])
                rest = self.helper(nums, new_mask, pairs + 1, dp)

                score = max(score, curr + rest)

        dp[mask] = score
        return score

    def maxScore(self, nums: List[int]) -> int:
        size = 1 << len(nums)
        dp = [-1] * size
        return self.helper(nums, 0, 0, dp)
