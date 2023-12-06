#!/usr/bin/env python3


class Solution:
    def totalMoney(self, n: int) -> int:
        rest = n % 7
        count = n // 7

        return 28 * count + 7 * (count - 1) * count // 2 + (1 + count + rest + count) * rest // 2
