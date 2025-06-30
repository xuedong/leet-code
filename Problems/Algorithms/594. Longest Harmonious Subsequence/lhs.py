#!/usr/bin/env python3

from typing import List


class Solution:
    def findLHS(self, nums: List[int]) -> int:
        nums.sort()
        
        j = 0
        length = 0
        for i in range(len(nums)):
            while nums[i] - nums[j] > 1:
                j += 1
            if nums[i] - nums[j] == 1:
                length = max(length, i - j + 1)
        return length
