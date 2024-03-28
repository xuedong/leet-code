#!/usr/bin/env python3

from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0

        ans = 0
        
        product = 1
        i = 0
        for j, num in enumerate(nums):
            product *= num
            while product >= k:
                product //= nums[i]
                i += 1
            ans += j - i + 1

        return ans
