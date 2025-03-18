#!/usr/bin/env python3

from typing import List


class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        used_bits = 0
        ans = 0

        start = 0
        for end in range(len(nums)):
            while used_bits & nums[end] != 0:
                used_bits ^= nums[start]
                start += 1

            used_bits |= nums[end]
            ans = max(ans, end - start + 1)

        return ans
