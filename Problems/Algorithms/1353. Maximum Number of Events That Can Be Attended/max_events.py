#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        max_day = max(event[1] for event in events)
        events.sort()

        pq = []
        n = len(events)
        ans = 0
        
        j = 0
        for i in range(1, max_day + 1):
            while j < n and events[j][0] <= i:
                heapq.heappush(pq, events[j][1])
                j += 1
            
            while pq and pq[0] < i:
                heapq.heappop(pq)
            if pq:
                heapq.heappop(pq)
                ans += 1

        return ans
        