#!/usr/bin/env python3

import bisect
from typing import List


class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        minimum = next(i for i, c in enumerate(count) if c > 0) * 1.0

        maximum = next(len(count) - 1 - i for i, c in enumerate(count[::-1]) if c > 0) * 1.0

        total = sum(count)
        mean = sum(i * count[i] for i in range(256)) / total

        mode = count.index(max(count)) * 1.0

        for i in range(255):
            count[i+1] += count[i]
        median = 0.0
        if total % 2 == 1:
            median = bisect.bisect(count, total // 2) * 1.0
        else:
            median = (bisect.bisect(count, (total-1) / 2) + bisect.bisect(count, total/2)) / 2.0

        return [minimum, maximum, mean, median, mode]
