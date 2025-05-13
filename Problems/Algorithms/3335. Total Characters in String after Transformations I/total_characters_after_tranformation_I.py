#!/usr/bin/env python3


class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        mod = 10 ** 9 + 7

        counts = [0] * 26
        for ch in s:
            counts[ord(ch) - ord('a')] += 1

        for i in range(t):
            nxt = [0] * 26
            nxt[0] = counts[25]
            nxt[1] = (counts[25] + counts[0]) % mod
            for j in range(2, 26):
                nxt[j] = counts[j-1]
            counts = nxt

        ans = sum(counts) % mod
        return ans
