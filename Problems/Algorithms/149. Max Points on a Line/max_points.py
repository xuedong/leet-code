#!/usr/bin/env python3

import sys
import math


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        if n <= 2:
            return n

        ans = 1
        for i in range(n-1):
            curr = 1
            lines = {}
            for j in range(i+1, n):
                x1, y1 = points[i][0], points[i][1]
                x2, y2 = points[j][0], points[j][1]
                slope = self.slope(x1, y1, x2, y2)
                lines[slope] = lines.get(slope, 1) + 1
                curr = max(lines[slope], curr)

            ans = max(ans, curr)

        return ans

    @staticmethod
    def slope(x1, y1, x2, y2):
        if x1 == x2:
            return (0, 0)
        if y1 == y2:
            return (sys.maxsize, sys.maxsize)

        delta_x, delta_y = x1 - x2, y1 - y2
        if delta_x < 0:
            delta_x, delta_y = -delta_x, -delta_y

        gcd = math.gcd(delta_x, delta_y)
        return (delta_x//gcd, delta_y//gcd)

