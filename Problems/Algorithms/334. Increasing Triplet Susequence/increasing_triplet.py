#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        if len(nums) < 3:
            return False
        
        i, j = nums[0], float('inf')
        for k in nums[1:]:
            if k > j:
                return True
            if k > i:
                j = k
            else:
                i = k
        return False
