#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        freq = defaultdict(int)
        nums.sort()
        return self.count(nums, k, freq, 0) - 1

    def count(self, nums, difference, freq, i):
        if i == len(nums):
            return 1

        total_count = self.count(nums, difference, freq, i + 1)

        if nums[i] - difference not in freq:
            freq[nums[i]] += 1
            total_count += self.count(nums, difference, freq, i + 1)
            freq[nums[i]] -= 1

            if freq[nums[i]] == 0:
                del freq[nums[i]]

        return total_count
