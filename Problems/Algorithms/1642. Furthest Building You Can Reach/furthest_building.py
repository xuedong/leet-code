#!/usr/bin/env python3

import heapq as hq


class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        n = len(heights)
        if n == 1:
            return 0

        queue = []
        hq.heapify(queue)

        total, length = 0, 0
        for i in range(1, n):
            curr = heights[i] - heights[i-1]
            if curr > 0:
                if length < ladders:
                    length += 1
                    hq.heappush(queue, curr)
                else:
                    hq.heappush(queue, curr)
                    peak = hq.heappop(queue)
                    total += peak
                    if total > bricks:
                        return i-1

        return n-1

