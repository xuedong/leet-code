#!usr/bin/env python3

from typing import List


class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        first, second = sum(grid[0]), 0
        ans = float("inf")

        for turn in range(len(grid[0])):
            first -= grid[0][turn]
            ans = min(ans, max(first, second))
            second += grid[1][turn]

        return ans
