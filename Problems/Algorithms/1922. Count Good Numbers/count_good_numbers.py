#!/usr/bin/env python3


class Solution:
    def countGoodNumbers(self, n: int) -> int:
        mod = 10 ** 9 + 7

        def fast_exp(x: int, y: int) -> int:
            ans, mul = 1, x
            while y > 0:
                if y % 2 == 1:
                    ans = ans * mul % mod
                mul = mul * mul % mod
                y //= 2

            return ans

        return fast_exp(5, (n+1)//2) * fast_exp(4, n//2) % mod
