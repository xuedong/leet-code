#!/usr/bin/env python3

from typing import List


class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        n = len(nums)
        costs = sorted([num, c] for num, c in zip(nums, cost))

        prefixes = [0] * n
        prefixes[0] = costs[0][1]
        for i in range(1, n):
            prefixes[i] = costs[i][1] + prefixes[i-1]

        total = 0
        for i in range(1, n):
            total += costs[i][1] * (costs[i][0] - costs[0][0])
        
        ans = total
        for i in range(1, n):
            gap = costs[i][0] - costs[i-1][0]
            total += prefixes[i-1] * gap
            total -= (prefixes[n-1] - prefixes[i-1]) * gap
            ans = min(ans, total)

        return ans
