#!/usr/bin/env python3

from typing import List


class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()

        ans = 0
        prefix = nums[0] + nums[1]
        for edge in nums[2:]:
            if prefix > edge:
                ans = prefix + edge
            prefix += edge
        
        return -1 if ans == 0 else ans
