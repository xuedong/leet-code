#!/usr/bin/env python3

import random
from typing import List
from bisect import bisect_left


class Solution:

    def __init__(self, rects: List[List[int]]):
        self.rects = rects
        self.points = [0]
        self.total = 0

        for rect in rects:
            a, b, x, y = rect
            self.total += (x - a + 1) * (y - b + 1)
            self.points.append(self.total)

    def pick(self) -> List[int]:
        idx = random.randint(1, self.total)
        point = bisect_left(self.points, idx)
        rect = self.rects[point-1]
        a, b, _, y = rect
        bias = idx - self.points[point-1] - 1
        return [a + bias // (y - b + 1), b + bias % (y - b + 1)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(rects)
# param_1 = obj.pick()