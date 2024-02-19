#!/usr/bin/env python3


class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        
        def count(left, right):
            ans = 0
            while left >= 0 and right < n and s[left] == s[right]:
                left -= 1
                right += 1
                ans += 1
            return ans

        ans = 0
        for i in range(n):
            even = count(i, i+1)
            odd = count(i, i)
            ans += even + odd
        
        return ans
