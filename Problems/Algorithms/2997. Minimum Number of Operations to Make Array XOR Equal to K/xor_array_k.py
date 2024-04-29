#!/usr/bin/env python3

from functools import reduce
from operator import xor
from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        return (reduce(xor, nums) ^ k).bit_count()
