#!/usr/bin/env python3

from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        result = set()
        current = []

        def helper(index):
            if index == len(nums):
                if len(current) >= 2:
                    result.add(tuple(current))
                return

            if not current or current[-1] <= nums[index]:
                current.append(nums[index])
                helper(index+1)
                current.pop()
            helper(index+1)

        helper(0)
        return result
