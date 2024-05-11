#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        n = len(quality)
        ans = float("inf")

        ratio = []
        for i in range(n):
            ratio.append((wage[i] / quality[i], quality[i]))
        ratio.sort(key=lambda x: x[0])

        curr = 0
        highest = []
        for i in range(n):
            heapq.heappush(highest, -ratio[i][1])
            curr += ratio[i][1]

            if len(highest) > k:
                curr += heapq.heappop(highest)

            if len(highest) == k:
                ans = min(ans, curr * ratio[i][0])

        return ans
