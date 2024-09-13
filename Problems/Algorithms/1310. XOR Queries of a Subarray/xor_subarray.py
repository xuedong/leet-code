#!/usr/bin/env python3

from typing import List


class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        n = len(arr)
        
        prefix = [0] * (n+1)
        for i in range(n):
            prefix[i+1] = prefix[i] ^ arr[i]

        ans = [prefix[r+1] ^ prefix[l] for l, r in queries]
        return ans
   