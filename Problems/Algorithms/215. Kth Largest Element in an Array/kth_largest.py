#!/usr/bin/env python3

import heapq as hq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = []
        hq.heapify(queue)
        for num in nums:
            hq.heappush(queue, num)
            if len(queue) > k:
                hq.heappop(queue)
        return hq.heappop(queue)

