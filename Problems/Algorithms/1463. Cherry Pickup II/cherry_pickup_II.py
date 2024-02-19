#!/usr/bin/env python3

from typing import List


class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])

        memo = {}

        def dp(r, c1, c2):
            if r == rows or c1 < 0 or c1 == cols or c2 < 0 or c2 == cols:
                return 0

            if (r, c1, c2) in memo:
                return memo[(r, c1, c2)]

            curr = grid[r][c1] + (grid[r][c2] if c1 != c2 else 0)
            prev = 0
            for i in [-1, 0, 1]:
                for j in [-1, 0, 1]:
                    prev = max(prev, dp(r+1, c1+i, c2+j))
            
            ans = curr + prev
            memo[(r, c1, c2)] = ans
            return ans

        return dp(0, 0, cols-1)
