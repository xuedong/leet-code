#!/usr/bin/env python3

from typing import List


class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        if n == 1:
            return 0

        ans = 0
        for i in range(len(points)-1):
            current, target = points[i], points[i+1]
            ans += max(abs(target[0]-current[0]), abs(target[1]-current[1]))

        return ans
