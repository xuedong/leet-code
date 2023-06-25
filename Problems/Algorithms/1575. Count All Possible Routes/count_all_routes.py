#!/usr/bin/env python3

from typing import List


class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        n = len(locations)

        memo = {}
        def aux(curr, rest):
            if rest < 0:
                return 0
            
            if (curr, rest) in memo:
                return memo[(curr, rest)]

            ans = 0
            if curr == finish:
                ans = 1
            for next in range(n):
                if next != curr:
                    cost = abs(locations[curr] - locations[next])
                    ans = (ans + aux(next, rest - cost)) % 1000000007

            memo[(curr, rest)] = ans
            return ans

        return aux(start, fuel)
