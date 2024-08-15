#!/usr/bin/env python3

from typing import List


class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        n = len(nums)

        nums.sort()

        low, high = 0, nums[n-1] - nums[0]
        while low < high:
            mid = (low + high) // 2

            count = self.count_pairs(nums, mid)
            if count < k:
                low = mid + 1
            else:
                high = mid

        return low


    def count_pairs(
        self, nums: List[int], max_distance: int
    ) -> int:
        count = 0
        n = len(nums)
        
        left = 0
        for right in range(n):
            while nums[right] - nums[left] > max_distance:
                left += 1
            count += right - left
        return count
