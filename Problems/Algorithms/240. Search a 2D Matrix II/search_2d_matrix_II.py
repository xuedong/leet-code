#!/usr/bin/env python3

from bisect import bisect_left


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            curr = bisect_left(matrix[i], target)
            if curr < len(matrix[i]) and matrix[i][curr] == target:
                return True
        return False

