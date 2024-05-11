#!/usr/bin/env python3

from typing import List
from heapq import heappush, heappop


class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        min_heap = []
        n = len(arr)

        for i in range(n):
            for j in range(i + 1, n):
                fraction = (arr[i] / arr[j], (arr[i], arr[j]))
                heappush(min_heap, fraction)
        
        for _ in range(k - 1):
            heappop(min_heap)

        return heappop(min_heap)[1]
