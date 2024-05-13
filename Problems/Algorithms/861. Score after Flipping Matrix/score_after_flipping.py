#!/usr/bin/env python3

from typing import List


class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] ^= 1

        for j in range(1, n):
            count = 0
            for i in range(m):
                if grid[i][j] == 0:
                    count += 1
            if count > m - count:
                for i in range(m):
                    grid[i][j] ^= 1

        score = 0
        for i in range(m):
            for j in range(n):
                column = grid[i][j] << (n-j-1)
                score += column

        return score
