#!/usr/bin/env python3


class Solution:
    def getLucky(self, s: str, k: int) -> int:
        num = ''
        for ch in s:
            num += str(ord(ch) - ord('a') + 1)

        while k > 0:
            curr = 0
            for ch in num:
                curr += int(ch)
            num = str(curr)
            k -= 1

        return int(num)
