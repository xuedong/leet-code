#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        freq = Counter(nums)
        return all(count % 2 == 0 for count in freq.values())
