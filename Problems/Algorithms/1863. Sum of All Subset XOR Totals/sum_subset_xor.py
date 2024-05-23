#!/usr/bin/env python3

from typing import List


class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans |= num
        return ans << (len(nums) - 1)
