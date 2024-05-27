#!/usr/bin/env python3

from typing import List


class Solution:
    def specialArray(self, nums: List[int]) -> int:
        n = len(nums)
        
        freq = [0] * (n + 1)
        for num in nums:
            freq[min(n, num)] += 1
        
        num_greater_than_or_equal = 0
        for i in range(n, 0, -1):
            num_greater_than_or_equal += freq[i]
            if i == num_greater_than_or_equal:
                return i
        
        return -1
