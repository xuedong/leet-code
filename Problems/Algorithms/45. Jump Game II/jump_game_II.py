#!/usr/bin/env python3

from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        ans = 0
        if len(nums) == 1:
            return ans
        
        end, far = 0, 0
        
        for i in range(len(nums)-1):
            far = max(far, i+nums[i])
            if i == end:
                ans += 1
                end = far
        
        return ans
