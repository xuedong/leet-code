#!/usr/bin/env python3


class Solution:
    def numberOfWays(self, corridor: str) -> int:
        ans = 1
        mod = 10 ** 9 + 7

        seats, plants = 0, 0
        for i in corridor:
            if i == 'S':
                seats += 1
            else:
                if seats == 2:
                    plants += 1
            
            if seats == 3:
                ans = ans * (plants + 1) % mod
                seats, plants = 1, 0

        if seats != 2:
            return 0

        return ans
