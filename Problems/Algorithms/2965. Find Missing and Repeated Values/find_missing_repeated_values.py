#!/usr/bin/env python3

from typing import List


class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        total = n * n

        sum_val = sum(num for row in grid for num in row)
        sqr_sum = sum(num * num for row in grid for num in row)

        sum_diff = sum_val - total * (total + 1) // 2
        sqr_diff = sqr_sum - total * (total + 1) * (2 * total + 1) // 6

        repeat = (sqr_diff // sum_diff + sum_diff) // 2
        missing = (sqr_diff // sum_diff - sum_diff) // 2

        return [repeat, missing]
