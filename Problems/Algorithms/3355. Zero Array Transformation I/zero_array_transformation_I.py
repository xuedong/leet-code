#!/usr/bin/env python3

from typing import List


class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        deltas = [0] * (len(nums) + 1)
        for left, right in queries:
            deltas[left] += 1
            deltas[right + 1] -= 1
        
        operations = []
        curr_operations = 0
        for delta in deltas:
            curr_operations += delta
            operations.append(curr_operations)

        for operation, target in zip(operations, nums):
            if operation < target:
                return False
        return True
