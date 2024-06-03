#!/usr/bin/env python3

from typing import List


class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        directions = [0, 1, 0, -1, 0]
        rows, cols = len(grid), len(grid[0])
        max_gold = 0

        def dfs(grid, rows, cols, row, col):
            if row < 0 or col < 0 or row == rows or col == cols or \
                    grid[row][col] == 0:
                return 0

            max_gold = 0
            original_val = grid[row][col]
            grid[row][col] = 0

            for direction in range(4):
                max_gold = max(max_gold, dfs(grid, rows, cols,  directions[direction] + row, directions[direction+1] + col))

            grid[row][col] = original_val
            return max_gold + original_val

        for row in range(rows):
            for col in range(cols):
                max_gold = max(max_gold, dfs(grid, rows, cols, row, col))

        return max_gold
