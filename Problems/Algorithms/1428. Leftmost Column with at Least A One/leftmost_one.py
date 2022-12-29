#!/usr/bin/env python3

from typing import List


# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
class BinaryMatrix(object):
    def get(self, row: int, col: int) -> int:
        pass

    def dimensions(self) -> List[int]:
        pass


class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        smallest_index = cols
        for row in range(rows):
            left, right = -1, cols
            while right - left > 1:
                mid = left + (right - left) // 2
                if binaryMatrix.get(row, mid) == 0:
                    left = mid
                else:
                    right = mid
            
            if left + 1 == cols:
                continue

            if binaryMatrix.get(row, left+1) == 1:
                smallest_index = min(smallest_index, left+1)

        return -1 if smallest_index == cols else smallest_index
