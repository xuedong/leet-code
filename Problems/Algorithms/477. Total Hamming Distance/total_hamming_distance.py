#!/usr/bin/env python3

from typing import List


class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        return sum([bits.count('0') * bits.count('1') for bits in zip(*map('{:032b}'.format, nums))])
