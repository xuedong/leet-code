#/usr/bin/env python3

from typing import List


class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        memo = [[float("inf")] * n for _ in range(m)]
        memo[0][0] = 0

        while True:
            prev = [row[:] for row in memo]

            for row in range(m):
                for col in range(n):
                    if row > 0:
                        memo[row][col] = min(memo[row][col], memo[row-1][col] + (0 if grid[row-1][col] == 3 else 1))
                    if col > 0:
                        memo[row][col] = min(memo[row][col], memo[row][col-1] + (0 if grid[row][col-1] == 1 else 1))

            for row in range(m-1, -1, -1):
                for col in range(n-1, -1, -1):
                    if row < m - 1:
                        memo[row][col] = min(memo[row][col], memo[row+1][col] + (0 if grid[row+1][col] == 4 else 1))
                    if col < n - 1:
                        memo[row][col] = min(memo[row][col], memo[row][col+1] + (0 if grid[row][col+1] == 2 else 1))

            if memo == prev:
                break

        return memo[m-1][n-1]
