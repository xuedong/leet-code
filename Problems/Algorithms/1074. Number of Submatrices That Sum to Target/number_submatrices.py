#!/usr/bin/env python3

from typing import List


class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        m, n = len(matrix), len(matrix[0])
        for row in range(m):
            for col in range(1, n):
                matrix[row][col] += matrix[row][col-1]

        ans = 0
        for i in range(n):
            for j in range(i, n):
                prefixes = {0: 1}

                total = 0
                for row in range(m):
                    total += matrix[row][j] - (matrix[row][i-1] if i > 0 else 0)
                    ans += prefixes.get(total - target, 0)
                    prefixes[total] = prefixes.get(total, 0) + 1

        return ans
