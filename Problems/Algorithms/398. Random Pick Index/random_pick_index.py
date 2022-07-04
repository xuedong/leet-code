#!/usr/bin/env python3

import random


class Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums

    def pick(self, target: int) -> int:
        ans = 0
        count = 0
        for i, num in enumerate(self.nums):
            if num == target:
                count += 1
                if random.randint(1, count) == count:
                    ans = i
        return ans

# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
