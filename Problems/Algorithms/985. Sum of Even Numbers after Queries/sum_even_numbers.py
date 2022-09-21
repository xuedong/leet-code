#!/usr/bin/env python3

from typing import List


class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        evens = sum([n for n in nums if n % 2 == 0])
        result = []
        for val, idx in queries:
            if nums[idx] % 2 == 0:
                evens -= nums[idx]
            nums[idx] += val
            if nums[idx] % 2 == 0:
                evens += nums[idx]
            result.append(evens)
        return result
