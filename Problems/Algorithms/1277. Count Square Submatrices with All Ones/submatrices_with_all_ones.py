#!/usr/bin/env python3

from typing import List


class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        def compute(i, j, grid, dp):
            if i >= len(grid) or j >= len(grid[0]):
                return 0
            if grid[i][j] == 0:
                return 0

            if dp[i][j] != -1:
                return dp[i][j]

            right = compute(i, j+1, grid, dp)
            diagonal = compute(i+1, j+1, grid, dp)
            below = compute(i+1, j, grid, dp)
            dp[i][j] = 1 + min(right, min(diagonal, below))
            return dp[i][j]

        ans = 0
        dp = [[-1 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                ans += compute(i, j, matrix, dp)

        return ans
