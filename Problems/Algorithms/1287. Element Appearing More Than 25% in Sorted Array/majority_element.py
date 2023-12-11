#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        counts = Counter(arr)
        n = len(arr)

        for key in counts:
            if counts[key] > n // 4:
                return key
