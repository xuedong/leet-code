#!/usr/bin/env python3

from typing import List


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        ans = self.rotate(tops, bottoms, tops[0])
        if tops[0] != bottoms[0]:
            ans = min(ans, self.rotate(tops, bottoms, bottoms[0]))

        return -1 if ans == float('inf') else ans

    def rotate(self, tops, bottoms, target):
        rotate_top = rotate_bottom = 0

        for i in range(len(tops)):
            if tops[i] != target and bottoms[i] != target:
                return float('inf')
            if tops[i] != target:
                rotate_top += 1
            if bottoms[i] != target:
                rotate_bottom += 1

        return min(rotate_top, rotate_bottom)
