#!/usr/bin/env python3

from collections import defaultdict
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m, n = len(s), len(p)
        if n > m:
            return []

        counts = defaultdict(int)
        result = []

        for ch in p:
            counts[ch] += 1

        for i in range(n-1):
            if s[i] in counts:
                counts[s[i]] -= 1

        for i in range(-1, m-n+1):
            if i > -1 and s[i] in counts:
                counts[s[i]] += 1
            if i + n < m and s[i+n] in counts: 
                counts[s[i+n]] -= 1
                
            if all(v == 0 for v in counts.values()): 
                result.append(i+1)
                
        return result
