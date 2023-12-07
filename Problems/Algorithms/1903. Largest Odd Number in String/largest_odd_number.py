#!/usr/bin/env python3


class Solution:
    def largestOddNumber(self, num: str) -> str:
        n = len(num)
        i = n - 1
        while int(num[i]) % 2 == 0 and i >= 0:
            i -= 1

        return num[:i+1] if i > -1 else ""
