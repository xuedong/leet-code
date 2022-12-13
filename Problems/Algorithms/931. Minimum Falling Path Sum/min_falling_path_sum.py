#!/usr/bin/env python3

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]

        for j in range(n):
            dp[0][j] = matrix[0][j]
        
        for i in range(1, m):
            for j in range(n):
                left = float('inf') if j == 0 else dp[i-1][j-1]
                right = float('inf') if j == n-1 else dp[i-1][j+1]
                mid = dp[i-1][j]
                dp[i][j] = matrix[i][j] + min(mid, min(left, right))
        
        res = dp[m-1][0]
        for j in range(1, n):
            res = min(res, dp[m-1][j])
        return res
