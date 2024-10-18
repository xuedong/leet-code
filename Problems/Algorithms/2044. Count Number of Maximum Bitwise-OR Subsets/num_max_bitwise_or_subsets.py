#!/usr/bin/env python3

from typing import List


class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_value = 0
        for num in nums:
            max_value |= num

        subsets = 1 << len(nums)
        max_subsets = 0

        for mask in range(subsets):
            curr = 0
            for i in range(len(nums)):
                if (mask >> i) & 1:
                    curr |= nums[i]

            if curr == max_value:
                max_subsets += 1
        
        return max_subsets
