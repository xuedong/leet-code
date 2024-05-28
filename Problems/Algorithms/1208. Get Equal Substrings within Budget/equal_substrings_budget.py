#!/usr/bin/env python3


class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        n = len(s)
        ans = 0
        start, curr = 0, 0

        for i in range(n):
            curr += abs(ord(s[i]) - ord(t[i]))
            while curr > maxCost:
                curr -= abs(ord(s[start]) - ord(t[start]))
                start += 1

            ans = max(ans, i-start+1)

        return ans
