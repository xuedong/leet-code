#!/usr/bin/env python3

from typing import List


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        rows, cols = len(points), len(points[0])
        prev = points[0]

        for row in range(1, rows):
            left, right = [0] * cols, [0] * cols
            curr = [0] * cols

            left[0] = prev[0]
            for col in range(1, cols):
                left[col] = max(left[col-1]-1, prev[col])

            right[-1] = prev[-1]
            for col in range(cols-2, -1, -1):
                right[col] = max(right[col+1]-1, prev[col])

            for col in range(cols):
                curr[col] = points[row][col] + max(left[col], right[col])

            prev = curr

        return max(prev)
