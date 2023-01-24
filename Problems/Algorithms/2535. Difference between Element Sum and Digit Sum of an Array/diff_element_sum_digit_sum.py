#!/usr/bin/env python3

from typing import List


class Solution:
    def get_diff(self, num: int) -> int:
        return sum([int(c) for c in str(num)])

    def differenceOfSum(self, nums: List[int]) -> int:
        return abs(sum([self.get_diff(num) for num in nums]) - sum(nums))
