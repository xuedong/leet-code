#!/usr/bin/env python3

from collections import Counter
from typing import List


class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        counts = Counter(stone % 3 for stone in stones)
        if counts[0] % 2 == 0:
            return counts[1] > 0 and counts[2] > 0
        return abs(counts[1] - counts[2]) > 2
        