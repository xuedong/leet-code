#!/usr/bin/env python3

from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        ans = 0
        n = len(strs[0])
     
        for i in range(n):
            curr = [string[i] for string in strs]
            if sorted(curr) != curr:
                ans += 1

        return ans
