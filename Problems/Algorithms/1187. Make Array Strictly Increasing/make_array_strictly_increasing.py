#!/usr/bin/env python3

import bisect
from typing import List


class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        dp = {}
        arr2.sort()

        def dfs(i, prev):
            if i == len(arr1):
                return 0
            if (i, prev) in dp:
                return dp[(i, prev)]

            cost = float('inf')
            if arr1[i] > prev:
                cost = dfs(i+1, arr1[i])

            target = bisect.bisect_right(arr2, prev)
            if target < len(arr2):
                cost = min(cost, 1 + dfs(i+1, arr2[target]))

            dp[(i, prev)] = cost
            return cost
        
        ans = dfs(0, -1)
        return ans if ans < float('inf') else -1
