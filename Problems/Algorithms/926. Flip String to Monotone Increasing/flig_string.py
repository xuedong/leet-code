#!/usr/bin/env python3


class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        n = len(s)
        dp0, dp1 = [0] * n, [0] * n

        dp0[0] = 0 if s[0] == '0' else 1
        dp1[0] = 0 if s[0] == '1' else 0
        for i in range(1, n):
            if s[i] == '0':
                dp0[i] = dp0[i-1]
                dp1[i] = min(dp0[i-1], dp1[i-1]) + 1
            else:
                dp0[i] = dp0[i-1] + 1
                dp1[i] = min(dp0[i-1], dp1[i-1])
        
        return min(dp0[n-1], dp1[n-1])
