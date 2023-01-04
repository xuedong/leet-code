#!/usr/bin/env python3

from collections import Counter
from typing import List


class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        counts = Counter(tasks)
        ans = 0
        for count in counts.values():
            curr = self.compute(count)
            if curr == -1:
                return -1
            ans += curr
        return ans

    def compute(self, n: int) -> int:
        if n <= 1:
            return -1
        if n == 2 or n == 3:
            return 1
        if n == 4 or n == 5 or n == 6:
            return 2
        return 1 + self.compute(n-3)
