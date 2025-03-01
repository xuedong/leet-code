#!/usr/bin/env python3

from typing import List


class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        n = len(nums)

        for i in range(n-1):
            if nums[i] == nums[i+1] and nums[i] != 0:
                nums[i] *= 2
                nums[i+1] = 0

        non_zero_index = 0
        for index in range(n):
            if nums[index] != 0:
                nums[non_zero_index] = nums[index]
                non_zero_index += 1

        while non_zero_index < n:
            nums[non_zero_index] = 0
            non_zero_index += 1

        return nums
