#!/usr/bin/env python3

from typing import List


class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        nums = [0] * 100

        ans = 0
        for x, y in dominoes:
            val = x * 10 + y if x <= y else y * 10 + x
            ans += nums[val]
            nums[val] += 1

        return ans
