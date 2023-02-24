#!/usr/bin/env python3

import heapq
from typing import List


class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        pq = []
        for num in nums:
            heapq.heappush(pq, [num // (num & -num), num])

        ans = float('inf')
        curr_max = max(num for num, _ in pq)
        while len(pq) == len(nums):
            curr, original = heapq.heappop(pq)
            ans = min(ans, curr_max - curr)
            if curr % 2 == 1 or curr < original:
                curr_max = max(curr_max, curr * 2)
                heapq.heappush(pq, [curr * 2, original])
        
        return ans
