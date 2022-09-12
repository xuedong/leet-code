#!/usr/bin/env python3

from typing import List


class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        nums.sort()
        return max(0, nums[len(nums)-1] - nums[0] - 2 * k)
