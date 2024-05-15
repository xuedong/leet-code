#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)

        queue = deque()
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    queue.append((i, j))
                    grid[i][j] = 0
                else:
                    grid[i][j] = -1

        while queue:
            size = len(queue)
            while size > 0:
                curr = queue.popleft()
                for dir in self.directions:
                    dx, dy = curr[0] + dir[0], curr[1] + dir[1]
                    val = grid[curr[0]][curr[1]]
                    if self.is_valid_cell(grid, dx, dy) and grid[dx][dy] == -1:
                        grid[dx][dy] = val + 1
                        queue.append((dx, dy))
                size -= 1

        start, end, res = 0, 0, -1
        for i in range(n):
            for j in range(n):
                end = max(end, grid[i][j])

        while start <= end:
            mid = start + (end - start) // 2
            if self.is_valid_safeness(grid, mid):
                res = mid
                start = mid + 1
            else:
                end = mid - 1

        return res

    def is_valid_cell(self, grid, i, j) -> bool:
        n = len(grid)
        return 0 <= i < n and 0 <= j < n

    def is_valid_safeness(self, grid, min_safeness) -> bool:
        n = len(grid)

        if grid[0][0] < min_safeness or grid[n-1][n-1] < min_safeness:
            return False

        queue = deque([(0, 0)])
        visited = [[False] * n for _ in range(n)]
        visited[0][0] = True

        while queue:
            curr = queue.popleft()
            if curr[0] == n-1 and curr[1] == n-1:
                return True

            for dir in self.directions:
                dx, dy = curr[0] + dir[0], curr[1] + dir[1]
                if self.is_valid_cell(grid, dx, dy) and not visited[dx][dy] and grid[dx][dy] >= min_safeness:
                    visited[dx][dy] = True
                    queue.append((dx, dy))

        return False
