#!/usr/bin/env python3

from typing import List


class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        ans = 0

        n = len(position)
        position.sort()

        low, high = 1, int(position[-1] / (m - 1.0)) + 1
        while low <= high:
            mid = low + (high - low) // 2

            if self.helper(mid, position, m):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
        return ans

    def helper(self, gap, position, balls):
        prev = position[0]
        placed = 1

        for i in range(1, len(position)):
            curr = position[i]

            if curr - prev >= gap:
                placed += 1
                prev = curr

            if placed == balls:
                return True
        return False
