#!/usr/bin/env python3

import math
from typing import List
from heapq import heappop, heappush


class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        distances = [[math.inf for _ in range(cols)] for _ in range(rows)]
        distances[0][0] = 0

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        min_heap = [(0, 0, 0)]
        while min_heap:
            x, y, effort = heappop(min_heap)

            if x == rows - 1 and y == cols - 1:
                return effort

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < rows and 0 <= ny < cols:
                    new_effort = max(effort, abs(heights[x][y] - heights[nx][ny]))

                    if new_effort < distances[nx][ny]:
                        distances[nx][ny] = new_effort
                        heappush(min_heap, (nx, ny, new_effort))
