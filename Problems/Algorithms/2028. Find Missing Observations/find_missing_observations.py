#!/usr/bin/env python3

from typing import List


class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        sum_rolls = sum(rolls)
        sum_remain = mean * (n + len(rolls)) - sum_rolls

        if sum_remain > 6 * n or sum_remain < n:
            return []

        mean_remain = sum_remain // n
        mod = sum_remain % n
        ans = [mean_remain] * n
        for i in range(mod):
            ans[i] += 1

        return ans
