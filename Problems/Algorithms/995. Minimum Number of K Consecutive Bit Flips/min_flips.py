#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        n = len(nums)
        queue = deque()
        flipped = 0

        ans = 0
        for i, num in enumerate(nums):
            if i >= k:
                flipped ^= queue[0]
            
            if flipped == nums[i]:
                if i + k > n:
                    return -1

                queue.append(1)
                flipped ^= 1
                ans += 1
            else:
                queue.append(0)

            if len(queue) > k:
                queue.popleft()

        return ans
