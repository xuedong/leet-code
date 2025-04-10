#!/usr/bin/env python3

from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        if k > nums[0]:
            return -1

        return len(set(nums)) - 1 if k == nums[0] else len(set(nums))
