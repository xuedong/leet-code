#!/usr/bin/env python3

from typing import List


class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        n = len(grid)
        expanded_grid = [[0] * (n * 3) for _ in range(n * 3)]

        for i in range(n):
            for j in range(n):
                base_row, base_col = 3 * i, 3 * j
                if grid[i][j] == "\\":
                    expanded_grid[base_row][base_col] = 1
                    expanded_grid[base_row+1][base_col+1] = 1
                    expanded_grid[base_row+2][base_col+2] = 1
                elif grid[i][j] == "/":
                    expanded_grid[base_row][base_col+2] = 1
                    expanded_grid[base_row+1][base_col+1] = 1
                    expanded_grid[base_row+2][base_col] = 1

        count = 0
        for i in range(n*3):
            for j in range(n*3):
                if expanded_grid[i][j] == 0:
                    self.flood_fill(expanded_grid, i, j)
                    count += 1

        return count
 

    def flood_fill(self, grid, row, col):
        queue = [(row, col)]
        grid[row][col] = 1

        while queue:
            curr = queue.pop(0)
            for direction in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                new_row, new_col = direction[0] + curr[0], direction[1] + curr[1]

                if self.is_valid(grid, new_row, new_col):
                    grid[new_row][new_col] = 1
                    queue.append((new_row, new_col))


    def is_valid(self, grid, row, col):
        n = len(grid)

        return row >= 0 and col >= 0 and row < n and col < n and grid[row][col] == 0
