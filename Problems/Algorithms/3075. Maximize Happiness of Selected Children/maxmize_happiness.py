#!/usr/bin/env python3

from typing import List


class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)

        ans, turns = 0, 0
        for i in range(k):
            ans += max(happiness[i] - turns, 0)
            turns += 1

        return ans
