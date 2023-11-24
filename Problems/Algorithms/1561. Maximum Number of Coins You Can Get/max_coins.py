#!/usr/bin/env python3

from typing import List


class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()

        ans = 0
        n = len(piles) // 3
        for i in range(3*n-2, n-1, -2):
            ans += piles[i]

        return ans
