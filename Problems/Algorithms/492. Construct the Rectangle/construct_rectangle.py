#!/usr/bin/env python3

from typing import List


class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        l, w = area, 1
        for i in range(int(area ** 0.5), 0, -1):
            if area % i == 0:
                l, w = area // i, i
                break
        return [l, w]
