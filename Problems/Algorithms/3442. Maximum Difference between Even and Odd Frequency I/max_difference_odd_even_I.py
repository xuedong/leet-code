#!/usr/bin/env python3

from collections import Counter


class Solution:
    def maxDifference(self, s: str) -> int:
        counts = Counter(s)

        odd_max = max([counts[ch] for ch in s if counts[ch] % 2 == 1])
        even_max = max([counts[ch] for ch in s if counts[ch] % 2 == 0])

        odd_min = min([counts[ch] for ch in s if counts[ch] % 2 == 1])
        even_min = min([counts[ch] for ch in s if counts[ch] % 2 == 0])
        
        return max(odd_max - even_min, odd_min - even_max)
