#!/usr/bin/env python3
# coding: utf-8


class Solution:
    dp = [0]

    def numSquares(self, n: int) -> int:
        if n <= 0:
            return 0
        
        dp = self.dp
        perfect_squares = [i * i for i in range(1, int(math.sqrt(n)) + 1)]
        while len(dp) <= n:
            curr = float('inf')
            for j in perfect_squares:
                if len(dp) < j:
                    break
                curr = min(curr, dp[-j] + 1)
            dp.append(curr)
        
        return dp[n]
