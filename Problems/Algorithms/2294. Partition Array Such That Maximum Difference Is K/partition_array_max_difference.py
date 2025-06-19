#!/usr/bin/env python3

from typing import List


class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()

        ans = 1
        split = nums[0]
        for num in nums:
            if num - split > k:
                ans += 1
                split = num
        return ans
