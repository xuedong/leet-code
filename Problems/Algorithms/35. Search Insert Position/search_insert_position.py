#!/usr/bin/env python3

from bisect import bisect_left
from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        return bisect_left(nums, target)
