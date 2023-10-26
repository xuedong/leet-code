#!/usr/bin/env python3

from typing import List


class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        mod = 10 ** 9 + 7

        arr.sort()
        factors = set(arr)
        dp = {num: 1 for num in arr}

        for i in arr:
            for j in arr:
                if j > i ** 0.5:
                    break
                
                if i % j == 0 and i // j in factors:
                    if i // j == j:
                        dp[i] += dp[j] * dp[j]
                    else:
                        dp[i] += dp[j] * dp[i // j] * 2
                    dp[i] %= mod

        return sum(dp.values()) % mod
