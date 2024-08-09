#!/usr/bin/env python3

from typing import List


class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        ans = 0
        for row in range(m-2):
            for col in range(n-2):
                if self.is_magic(grid, row, col):
                    ans += 1
        return ans

    def is_magic(self, grid, row, col):
        sequence = "2943816729438167"
        sequence_reversed = "7618349276183492"

        border = []
        indices = [0, 1, 2, 5, 8, 7, 6, 3]
        for i in indices:
            border.append(str(grid[row + i//3][col + i%3]))

        border_string = "".join(border)
        return grid[row][col] % 2 == 0 and (sequence.find(border_string) != -1 or sequence_reversed.find(border_string) != -1) and grid[row+1][col+1] == 5
