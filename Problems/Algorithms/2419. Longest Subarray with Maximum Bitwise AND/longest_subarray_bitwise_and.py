#!/usr/bin/env python3

from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        maximum, curr = 0, 0
        ans = 0
        for num in nums:
            if maximum < num:
                maximum = num
                ans, curr = 0, 0

            if maximum == num:
                curr += 1
            else:
                curr = 0

            ans = max(ans, curr)

        return ans
