#!/usr/bin/env python3

from typing import List


class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        n = len(colors)

        ans = 0
        for i in range(n-1):
            if colors[i] == colors[i+1]:
                ans += min(neededTime[i], neededTime[i+1])
                neededTime[i+1] = max(neededTime[i+1], neededTime[i])

        return ans
