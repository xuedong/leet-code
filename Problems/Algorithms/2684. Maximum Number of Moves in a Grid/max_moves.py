#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        queue = deque()
        visited = [[False] * n for _ in range(m)]
        for i in range(m):
            visited[i][0] = True
            queue.append((i, 0, 0))

        moves = 0
        while queue:
            size = len(queue)

            for _ in range(size):
                row, col, count = queue.popleft()

                moves = max(moves, count)

                for direction in [-1, 0, 1]:
                    new_row, new_col = row + direction, col + 1

                    if 0 <= new_row < m and 0 <= new_col < n and not visited[new_row][new_col] and grid[row][col] < grid[new_row][new_col]:
                        visited[new_row][new_col] = True
                        queue.append((new_row, new_col, count+1))

        return moves
