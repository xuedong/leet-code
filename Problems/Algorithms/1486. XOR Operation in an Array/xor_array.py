#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        ans = start
        for i in range(1, n):
            ans = ans ^ (start + 2 * i)
        return ans
