#!/usr/bin/env python3

from typing import List


class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        left, right = 0, 0
        n = len(fruits)

        def step(left: int, right: int) -> int:
            if fruits[right][0] <= startPos:
                return startPos - fruits[left][0]
            
            if fruits[left][0] >= startPos:
                return fruits[right][0] - startPos

            return min(abs(startPos - fruits[right][0]), abs(startPos - fruits[left][0])) + fruits[right][0] - fruits[left][0]

        cur, ans = 0, 0
        while right < n:
            cur += fruits[right][1]
            while left <= right and step(left, right) > k:
                cur -= fruits[left][1]
                left += 1
            
            ans = max(ans, cur)
            right += 1

        return ans
