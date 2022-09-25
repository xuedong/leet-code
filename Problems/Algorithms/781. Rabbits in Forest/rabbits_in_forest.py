#!/usr/bin/env python3

from collections import Counter
from typing import List


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        counts = Counter(answers)
        ans = 0
        for key, value in counts.items():
            num = value // (key + 1)
            num = num + 1 if value % (key + 1) != 0 else num
            ans += num * (key + 1)
        return ans
