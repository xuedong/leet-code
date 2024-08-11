#!/usr/bin/env python3

from typing import List


class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        initial = self.count(grid)
        if initial != 1:
            return 0

        for row in range(m):
            for col in range(n):
                if grid[row][col] == 0:
                    continue

                grid[row][col] = 0
                curr = self.count(grid)
                if curr != 1:
                    return 1

                grid[row][col] = 1

        return 2

    
    def count(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        
        islands = 0
        for row in range(m):
            for col in range(n):
                if not visited[row][col] and grid[row][col] == 1:
                    self.explore(grid, row, col, visited)
                    islands += 1

        return islands

    
    def explore(self, grid: List[List[int]], row: int, col: int, visited: List[List[bool]]) -> None:
        visited[row][col] = True

        for direction in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            curr_row = row + direction[0]
            curr_col = col + direction[1]
            if self.is_valid(grid, curr_row, curr_col, visited):
                self.explore(grid, curr_row, curr_col, visited)


    def is_valid(self, grid: List[List[int]], row: int, col: int, visited: List[List[bool]]) -> bool:
        m, n = len(grid), len(grid[0])
        return 0 <= row < m and 0 <= col < n and grid[row][col] == 1 and not visited[row][col]
