#!/usr/bin/env python3

from collections import Counter


class Solution:
    def robotWithString(self, s: str) -> str:
        count = Counter(s)
        stack = []
        res = []

        min_ch = "a"
        for ch in s:
            stack.append(ch)
            count[ch] -= 1
            while min_ch != "z" and count[min_ch] == 0:
                min_ch = chr(ord(min_ch) + 1)
            while stack and stack[-1] <= min_ch:
                res.append(stack.pop())

        return "".join(res)
