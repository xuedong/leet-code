#!/usr/bin/env python3

import heapq
from typing import List
from collections import Counter


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if k >= len(nums):
            return nums

        counter = Counter(nums)

        return heapq.nlargest(k, counter.keys(), key=counter.get)

