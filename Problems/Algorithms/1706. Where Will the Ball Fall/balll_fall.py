#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from typing import List


class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        ans = []
        for i in range(n):
            x, y = 0, i
            while x < m:
                if grid[x][y] == 1:
                    if y == n - 1 or grid[x][y + 1] == -1:
                        ans.append(-1)
                        break
                    y += 1
                else:
                    if y == 0 or grid[x][y - 1] == 1:
                        ans.append(-1)
                        break
                    y -= 1
                x += 1
            else:
                ans.append(y)
        return ans
