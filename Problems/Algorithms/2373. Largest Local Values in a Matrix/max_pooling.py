#!/usr/bin/env python3

from typing import List


class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)

        max_local = [[0] * (n-2) for _ in range(n-2)]
        for i in range(n-2):
            for j in range(n-2):
                max_local[i][j] = self.find(grid, i, j)

        return max_local

    def find(self, grid, x, y):
        ans = 0
        for i in range(x, x+3):
            for j in range(y, y+3):
                ans = max(ans, grid[i][j])

        return ans
