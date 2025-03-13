#!/usr/bin/env python3

from typing import List


class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)

        total = 0
        k = 0
        difference = [0] * (n+1)

        for i in range(n):
            while total + difference[i] < nums[i]:
                k += 1
                if k > len(queries):
                    return -1

                left, right, val = queries[k-1]
                if right >= i:
                    difference[max(left, i)] += val
                    difference[right+1] -= val

            total += difference[i]

        return k
