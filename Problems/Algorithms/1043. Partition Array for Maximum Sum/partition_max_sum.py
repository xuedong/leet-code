#!/usr/bin/env python3

from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n+1)

        for i in range(1, n+1):
            curr, best = 0, 0

            for j in range(1, k+1):
                if j <= i:
                    curr = max(curr, arr[i-j])
                    best = max(best, dp[i-j] + curr * j)
            dp[i] = best

        return dp[n]
