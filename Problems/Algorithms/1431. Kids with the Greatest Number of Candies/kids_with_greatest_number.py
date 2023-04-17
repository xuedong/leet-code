#!/usr/bin/env python3

from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        n, best = len(candies), max(candies)
        ans = [False] * n
        for i in range(n):
            candy = candies[i]
            if candy + extraCandies >= best:
                ans[i] = True
        
        return ans
