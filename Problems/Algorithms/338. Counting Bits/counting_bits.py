#!/usr/bin/env python3

from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        curr = 0
        ans = []

        for i in range(n+1):
            curr = bin(i).count("1")
            ans.append(curr)

        return ans
