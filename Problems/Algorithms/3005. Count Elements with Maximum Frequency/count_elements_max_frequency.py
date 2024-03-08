#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        frequencies = defaultdict(int)
        for num in nums:
            frequencies[num] += 1

        max_freq = max(frequencies.values())
        
        count = 0
        for freq in frequencies.values():
            if freq == max_freq:
                count += 1

        return count * max_freq
