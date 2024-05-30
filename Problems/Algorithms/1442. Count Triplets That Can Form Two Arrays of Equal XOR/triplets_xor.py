#!/usr/bin/env python3

from typing import List


class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        prefix = [0] + arr[:]
        n = len(prefix)

        for i in range(1, n):
            prefix[i] ^= prefix[i - 1]

        count = 0
        for start in range(n):
            for end in range(start + 1, n):
                if prefix[start] == prefix[end]:
                    count += end - start - 1

        return count
