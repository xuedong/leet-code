#!/usr/bin/env python3


class Solution:
    def countHomogenous(self, s: str) -> int:
        ans = 0
        curr = 0
        mod = 10 ** 9 + 7
        
        for i in range(len(s)):
            if i == 0 or s[i] == s[i-1]:
                curr += 1
            else:
                curr = 1

            ans = (ans + curr) % mod

        return ans
