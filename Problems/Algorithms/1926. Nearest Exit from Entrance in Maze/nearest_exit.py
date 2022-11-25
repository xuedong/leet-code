#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        n, m = len(maze), len(maze[0])

        neighbors = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        visited = set()

        queue = [tuple(entrance)]
        visited.add(tuple(entrance))
        steps = 0
        while queue:
            steps += 1
            for _ in range(len(queue)):
                x, y = queue.pop(0)
                for dx, dy in neighbors:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < m and maze[nx][ny] == '.' and (nx, ny) not in visited:
                        if nx == 0 or nx == n - 1 or ny == 0 or ny == m - 1:
                            return steps
                        visited.add((nx, ny))
                        queue.append((nx, ny))

        return -1
