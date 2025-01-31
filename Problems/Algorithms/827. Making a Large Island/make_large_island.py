#!/usr/bin/env python3

from typing import List


class Solution:
    def __explore(self, grid: List[List[int]], island_id: int, row: int, col: int) -> int:
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] != 1:
            return 0

        grid[row][col] = island_id
        below = self.__explore(grid, island_id, row+1, col)
        above = self.__explore(grid, island_id, row-1, col)
        left = self.__explore(grid, island_id, row, col-1)
        right = self.__explore(grid, island_id, row, col+1)
        return 1 + below + above + left + right

    def largestIsland(self, grid: List[List[int]]) -> int:
        sizes = {}
        island_id = 2
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    sizes[island_id] = self.__explore(grid, island_id, row, col)
                    island_id += 1

        if not sizes:
            return 1

        if len(sizes) == 1:
            island_id -= 1
            return sizes[island_id] if sizes[island_id] == len(grid) * len(grid[0]) else sizes[island_id] + 1

        max_size = 1
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 0:
                    curr_size = 1
                    neighbors = set()

                    if row + 1 < len(grid) and grid[row+1][col] > 1:
                        neighbors.add(grid[row+1][col])
                    if row - 1 >= 0 and grid[row-1][col] > 1:
                        neighbors.add(grid[row-1][col])
                    if col + 1 < len(grid[0]) and grid[row][col+1] > 1:
                        neighbors.add(grid[row][col+1])
                    if col - 1 >= 0 and grid[row][col-1] > 1:
                        neighbors.add(grid[row][col-1])

                    for island_id in neighbors:
                        curr_size += sizes[island_id]
                    max_size = max(max_size, curr_size)

        return max_size
