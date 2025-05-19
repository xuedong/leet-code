#!/usr/bin/env python3

from typing import List


class Solution:
    def triangleType(self, nums: List[int]) -> str:
        nums.sort()

        if nums[0] == nums[1] == nums[2]:
            return "equilateral"
        elif (nums[0] == nums[1] and nums[0] + nums[1] > nums[2]) or (nums[1] == nums[2]):
            return "isosceles"
        elif nums[0] + nums[1] > nums[2]:
            return "scalene"
        return "none"
