#!/usr/bin/env python3

from typing import List
from sys import maxsize
from bisect import bisect_right


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        nums = sorted(set(nums))

        ans = maxsize
        for i, num in enumerate(nums):
            end = num + n - 1
            j = bisect_right(nums, end)

            ans = min(ans, n - (j - i))

        return ans
