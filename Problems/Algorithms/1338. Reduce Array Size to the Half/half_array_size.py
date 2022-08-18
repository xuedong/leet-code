#!/usr/bin/env python3

import heapq as hq
from collections import Counter


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        n = len(arr)
        counts = Counter(arr)
        
        pq = []
        hq.heapify(pq)
        for _, value in counts.items():
            hq.heappush(pq, -value)

        ans, count = 0, 0
        while count < n // 2:
            count += -hq.heappop(pq)
            ans += 1

        return ans
        