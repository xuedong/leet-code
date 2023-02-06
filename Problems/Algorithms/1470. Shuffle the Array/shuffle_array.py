#!/usr/bin/env python3

from typing import List


class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        return [nums[:n][(i+1)//2] if i % 2 == 0 else nums[n:][i//2] for i in range(2*n)]
