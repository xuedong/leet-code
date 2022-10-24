#!/usr/bin/env python3
# coding=utf-8

from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        s = sum(nums)
        s1 = sum(set(nums))
        return [s - s1, n * (n + 1) // 2 - s1]
