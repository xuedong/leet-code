#!/usr/bin/env python3

from typing import List


class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        ans = float("inf")

        ones = sum(nums)
        count = nums[0]
        n = len(nums)
        
        end = 0
        for start in range(n):
            if start != 0:
                count -= nums[start-1]

            while end - start + 1 < ones:
                end += 1
                count += nums[end % n]

            ans = min(ans, ones - count)

        return ans
