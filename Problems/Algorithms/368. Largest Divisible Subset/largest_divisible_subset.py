#!/usr/bin/env python3

from typing import List


class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()

        n = len(nums)
        dp = [1] * n

        max_size, max_index = 1, 0
        for i in range(1, n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], dp[j]+1)
                    if dp[i] > max_size:
                        max_size = dp[i]
                        max_index = i

        ans = []
        curr = nums[max_index]
        for i in range(max_index, -1, -1):
            if curr % nums[i] == 0 and dp[i] == max_size:
                ans.append(nums[i])
                curr = nums[i]
                max_size -=1

        return ans
