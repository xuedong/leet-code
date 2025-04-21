#!/usr/bin/env python3

from typing import List


class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        x = y = curr = 0
        for diff in differences:
            curr += diff
            x = min(x, curr)
            y = max(y, curr)
            if y - x > upper - lower:
                return 0
        return (upper - lower) - (y - x) + 1
