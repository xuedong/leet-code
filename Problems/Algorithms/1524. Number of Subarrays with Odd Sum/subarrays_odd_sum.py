#!/usr/bin/env python3

from typing import List


class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        mod = 10 ** 9 + 7

        count, odds, evens = 0, 0, 1
        prefix = 0

        for num in arr:
            prefix += num

            if prefix % 2 == 0:
                count += odds
                evens += 1
            else:
                count += evens
                odds += 1

            count %= mod

        return count
