#!/usr/bin/env python3

from queue import PriorityQueue
from typing import List


class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        rows, cols = len(grid), len(grid[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        sorted_queries = sorted([(val, idx) for idx, val in enumerate(queries)])
        
        heap = PriorityQueue()
        heap.put((grid[0][0], 0, 0))

        visited = [[False] * cols for _ in range(rows)]
        visited[0][0] = True

        points = 0
        result = [0] * len(queries)
        for value, idx in sorted_queries:
            while not heap.empty() and heap.queue[0][0] < value:
                curr_value, curr_row, curr_col = heap.get()

                points += 1

                for dx, dy in directions:
                    new_row, new_col = curr_row + dx, curr_col + dy

                    if new_row >= 0 and new_col >= 0 and new_row < rows and new_col < cols and not visited[new_row][new_col]:
                        heap.put((grid[new_row][new_col], new_row, new_col))
                        visited[new_row][new_col] = True

            result[idx] = points

        return result
