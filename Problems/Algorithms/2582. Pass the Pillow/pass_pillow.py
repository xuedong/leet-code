#!/usr/bin/env python3


class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        full = time // (n-1)
        rest = time % (n-1)

        if full % 2 == 0:
            return rest + 1
        return n - rest
