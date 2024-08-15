#!/usr/bin/env python3

from typing import List


class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        n = len(nums)

        largest = max(nums)
        bucket = [0] * (largest+1)

        for i in range(n):
            for j in range(i+1, n):
                distance = abs(nums[i] - nums[j])
                bucket[distance] += 1

        for distance in range(largest+1):
            k -= bucket[distance]

            if k <= 0:
                return distance

        return -1
