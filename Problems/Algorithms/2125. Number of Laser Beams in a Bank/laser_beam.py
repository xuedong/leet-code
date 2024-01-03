#!/usr/bin/env python3

from typing import List


class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        n = len(bank)
        devices = [0] * n
        for i in range(n):
            devices[i] = bank[i].count('1')

        ans, prev = 0, 0
        for i in range(n):
            curr = devices[i]
            if curr != 0:
                ans += prev * curr
                prev = curr

        return ans
