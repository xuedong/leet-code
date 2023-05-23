#!/usr/bin/env python3

import heapq
from typing import List


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.nums = nums[0:k]
        heapq.heapify(self.nums)
        self.k = k

        for num in nums[k:]:
            if self.nums[0] < num:
                heapq.heappushpop(self.nums, num)

    def add(self, val: int) -> int:
        if len(self.nums) < self.k:
            heapq.heappush(self.nums, val)
            return self.nums[0]
        
        if self.nums[0] < val:
            heapq.heappushpop(self.nums, val)

        return self.nums[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)