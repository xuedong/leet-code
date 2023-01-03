#!/usr/bin/env python3

from typing import List


class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        placement = 0
        for i in range(len(shift)):
            placement += shift[i][1] if shift[i][0] == 1 else -shift[i][1]
        placement = placement % len(s)

        return s[-placement:] + s[:-placement]
