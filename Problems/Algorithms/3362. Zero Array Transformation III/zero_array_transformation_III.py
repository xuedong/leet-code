#!/usr/bin/env python3

from typing import List
from heapq import heappush, heappop


class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        queries.sort(key=lambda x: x[0])

        hp = []
        deltas = [0] * (len(nums) + 1)
        operations = 0

        j = 0
        for i, num in enumerate(nums):
            while j < len(queries) and queries[j][0] == i:
                heappush(hp, -queries[j][1])
                j += 1

            operations += deltas[i]
            while operations < num and hp and -hp[0] >= i:
                operations += 1
                deltas[-heappop(hp) + 1] -= 1

            if operations < num:
                return -1

        return len(hp)
