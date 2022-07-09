#!/usr/bin/env python3

import heapq as hq


class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)

        dp = [0] * n
        dp[n-1] = nums[n-1]

        queue = []
        hq.heapify(queue)

        for i in reversed(range(n)):
            while queue and queue[0][1] > i+k:
                hq.heappop(queue)
            curr = -queue[0][0] if queue else 0
            dp[i] = nums[i] + curr
            hq.heappush(queue, [-dp[i], i])

        return dp[0]

