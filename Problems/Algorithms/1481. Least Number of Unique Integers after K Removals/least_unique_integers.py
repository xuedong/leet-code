#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        freqs = sorted(Counter(arr).values())
        for i, freq in enumerate(freqs):
            k -= freq
            if k < 0:
                return len(freqs) - i
        return 0
