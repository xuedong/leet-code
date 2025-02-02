#!/usr/bin/env python3

from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 1:
            return True

        count = 0
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                count += 1

        if nums[0] < nums[n-1]:
            count += 1

        return count <= 1
