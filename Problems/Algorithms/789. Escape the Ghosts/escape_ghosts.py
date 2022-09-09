#!/usr/bin/env python3

from typing import List


class Solution:
    def manhatan_distance(self, x: List[int], y: List[int]) -> int:
        return abs(x[0] - y[0]) + abs(x[1] - y[1])

    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        distances = [self.manhatan_distance(ghost, target) for ghost in ghosts]
        return min(distances) > self.manhatan_distance([0, 0], target)
        