#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        pq = []
        for i in range(n):
            heapq.heappush(pq, (nums[i], i))

        ans = 0
        mod = 1e9 + 7
        for i in range(1, right+1):
            curr = heapq.heappop(pq)

            if i >= left:
                ans = (ans + curr[0]) % mod

            if curr[1] < n - 1:
                heapq.heappush(pq, (curr[0] + nums[curr[1] + 1], curr[1] + 1))
        
        return int(ans)
