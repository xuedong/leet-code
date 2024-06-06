#!/usr/bin/env python3

from typing import List
from collections import Counter
import heapq


class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        size = len(hand)
        if size % groupSize != 0:
            return False

        counts = Counter(hand)
        heap = list(counts.keys())
        heapq.heapify(heap)

        while heap:
            curr = heap[0]
            for i in range(groupSize):
                if counts[curr+i] == 0:
                    return False
                counts[curr+i] -= 1
                if counts[curr+i] == 0:
                    if curr + i != heapq.heappop(heap):
                        return False

        return True
