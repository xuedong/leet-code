#!/usr/bin/env python3

import math
from typing import List


class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        min_rank, max_rank = ranks[0], ranks[0]
        for rank in ranks:
            min_rank = min(min_rank, rank)
            max_rank = max(max_rank, rank)

        freq = [0] * (max_rank + 1)
        for rank in ranks:
            freq[rank] += 1

        low, high = 0, min_rank * cars * cars + 1
        while high - low > 1:
            mid = low + (high - low) // 2
            repairs = 0

            for rank in range(1, max_rank + 1):
                repairs += freq[rank] * int(math.sqrt(mid // rank))

            if repairs >= cars:
                high = mid
            else:
                low = mid

        return low + 1
