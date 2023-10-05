#!/usr/bin/env python3

from typing import List
from collections import Counter

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        counts = Counter(nums)

        majorities = []
        threshold = len(nums) // 3

        for element, count in counts.items():
            if count > threshold:
                majorities.append(element)

        return majorities
