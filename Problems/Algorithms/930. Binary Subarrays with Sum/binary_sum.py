#!/usr/bin/env python3

from typing import List


class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        count, current = 0, 0
        freq = {}

        for num in nums:
            current += num
            if current == goal:
                count += 1

            if current - goal in freq:
                count += freq[current - goal]

            freq[current] = freq.get(current, 0) + 1

        return count
