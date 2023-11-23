#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        def rev(num):
            reverse = 0

            while num:
                reverse = reverse * 10 + num % 10
                num //= 10

            return reverse

        mod = 10 ** 9 + 7

        processed = []
        for i in range(len(nums)):
            processed.append(nums[i] - rev(nums[i]))

        freq = defaultdict(int)
        ans = 0
        for num in processed:
            ans = (ans + freq[num]) % mod
            freq[num] += 1

        return ans
