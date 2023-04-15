#!/usr/bin/env python3

from typing import List


class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)
        dp = [[0 for _ in range(k + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for coins in range(0, k + 1):
                curr = 0
                for coin in range(0, min(len(piles[i - 1]), coins) + 1):
                    if coin > 0:
                        curr += piles[i - 1][coin - 1]
                    dp[i][coins] = max(dp[i][coins], dp[i - 1][coins - coin] + curr)

        return dp[n][k]
