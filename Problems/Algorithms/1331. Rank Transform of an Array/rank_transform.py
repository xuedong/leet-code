#!/usr/bin/env python3

from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        ranks = {}
        sorted_arr = sorted(arr)
        n = len(arr)

        rank = 1
        for i in range(n):
            if i > 0 and sorted_arr[i] > sorted_arr[i-1]:
                rank += 1
            ranks[sorted_arr[i]] = rank

        for i in range(n):
            arr[i] = ranks[arr[i]]
        return arr
