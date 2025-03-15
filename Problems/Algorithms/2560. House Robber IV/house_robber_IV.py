#!/usr/bin/env python3

from typing import List


class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        left, right = 0, max(nums)+1
        n = len(nums)

        while right - left > 1:
            mid = left + (right - left) // 2
            thefts = 0

            i = 0
            while i < n:
                if nums[i] <= mid:
                    thefts += 1
                    i += 2
                else:
                    i += 1

            if thefts >= k:
                right = mid
            else:
                left = mid

        return left+1
