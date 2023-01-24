#!/usr/bin/env python3

from typing import List


class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            curr = num
            for i in [1000, 100, 10]:
                ans += (i-1) * (curr // i)
                curr = curr % i
        return ans
