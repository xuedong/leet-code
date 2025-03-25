#!/usr/bin/env python3

from typing import List


class Solution:
    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        def _check(rectangles: List[List[int]], dim: int) -> bool:
            gaps = 0
            rectangles.sort(key=lambda rectangle: rectangle[dim])
            
            curr = rectangles[0][dim+2]
            for i in range(1, len(rectangles)):
                rectangle = rectangles[i]

                if curr <= rectangle[dim]:
                    gaps += 1

                curr = max(curr, rectangle[dim+2])

            return gaps >= 2

        return _check(rectangles, 0) or _check(rectangles, 1)
