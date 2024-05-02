#!/usr/bin/env python3


class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        freq = {}
        freq[0] = 1

        mask, ans = 0, 0
        for ch in word:
            bit = ord(ch) - 97
            mask ^= (1 << bit)

            if mask in freq:
                ans += freq[mask]
                freq[mask] += 1
            else:
                freq[mask] = 1

            for letter in range(0, 10):
                if (mask ^ (1 << letter)) in freq:
                    ans += freq[mask ^ (1 << letter)]

        return ans
