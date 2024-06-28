#!/usr/bin/env python3

from typing import List


class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        degrees = [0] * n
        for edge in roads:
            degrees[edge[0]] += 1
            degrees[edge[1]] += 1

        degrees.sort()
        
        value = 1
        ans = 0
        for degree in degrees:
            ans += value * degree
            value += 1
        
        return ans
