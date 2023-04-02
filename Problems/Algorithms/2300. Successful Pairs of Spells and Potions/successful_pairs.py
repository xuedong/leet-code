#!/usr/bin/env python3

import bisect
from math import ceil
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()

        n = len(potions)
        max_potion = potions[n-1]

        results = []
        for spell in spells:
            min_potion = ceil(success / spell)
            if min_potion > max_potion:
                results.append(0)
                continue
            
            curr = bisect.bisect_left(potions, min_potion)
            results.append(n - curr)

        return results
