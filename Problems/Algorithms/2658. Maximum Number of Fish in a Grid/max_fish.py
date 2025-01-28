#!/usr/bin/env python3

from typing import List


class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] and not visited[i][j]:
                    ans = max(ans, self.__count(grid, visited, i, j))

        return ans

    def __count(self, grid, visited, row, col):
        m, n = len(grid), len(grid[0])
        
        rows = [0, 0, 1, -1]
        cols = [1, -1, 0, 0]

        queue = [(row, col)]
        visited[row][col] = True

        count = 0
        while queue:
            row, col = queue.pop(0)
            count += grid[row][col]

            for i in range(4):
                next_row = row + rows[i]
                next_col = col + cols[i]

                if 0 <= next_row < m and 0 <= next_col < n and grid[next_row][next_col] and not visited[next_row][next_col]:
                    queue.append((next_row, next_col))
                    visited[next_row][next_col] = True

        return count
