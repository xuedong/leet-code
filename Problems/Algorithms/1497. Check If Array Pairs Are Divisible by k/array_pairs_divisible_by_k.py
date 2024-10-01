#!/usr/bin/env python3

from typing import List


class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        count = {}

        for i in arr:
            count[(i % k + k) % k] = count.get((i % k + k) % k, 0) + 1

        for i in arr:
            curr = (i % k + k) % k
            if curr == 0:
                if count[curr] % 2 == 1:
                    return False
            elif count[curr] != count.get(k - curr, 0):
                return False
        return True
