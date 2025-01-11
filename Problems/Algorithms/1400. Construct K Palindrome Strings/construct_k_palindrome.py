#!/usr/bin/env python3


class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False

        if len(s) == k:
            return True

        freq = [0] * 26
        odd_count = 0

        for ch in s:
            freq[ord(ch) - ord("a")] += 1

        for count in freq:
            if count % 2 == 1:
                odd_count += 1

        return odd_count <= k
