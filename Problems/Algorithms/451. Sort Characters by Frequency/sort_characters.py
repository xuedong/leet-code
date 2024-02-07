#!/usr/bin/env python3

import heapq
from collections import Counter


class Solution:
    def frequencySort(self, s: str) -> str:
        counts = Counter(s)

        pq = [(-freq, char) for char, freq in counts.items()]
        heapq.heapify(pq)

        ans = ''
        while pq:
            freq, char = heapq.heappop(pq)
            ans += char * -freq
        
        return ans
