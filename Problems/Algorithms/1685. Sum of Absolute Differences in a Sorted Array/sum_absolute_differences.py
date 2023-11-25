#!/usr/bin/env python3

from typing import List


class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        n = len(nums)

        prefix = [nums[0]]
        for i in range(1, n):
            prefix.append(prefix[-1] + nums[i])

        ans = []
        for i in range(n):
            left = prefix[i] - nums[i]
            right = prefix[-1] - prefix[i]

            curr = i * nums[i] - left + right - (n-1-i) * nums[i]
            ans.append(curr)

        return ans
