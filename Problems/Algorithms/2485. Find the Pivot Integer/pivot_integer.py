#!/usr/bin/env python3

from math import sqrt


class Solution:
    def pivotInteger(self, n: int) -> int:
        total = n * (n+1) // 2
        pivot = int(sqrt(total))
        return pivot if pivot * pivot == total else -1
