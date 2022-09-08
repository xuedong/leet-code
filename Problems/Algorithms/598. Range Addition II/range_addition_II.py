#!/usr/bin/env python3

from typing import List


class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        if not ops:
            return m * n
        return min([ops[i][0] for i in range(len(ops))]) * min([ops[i][1] for i in range(len(ops))])
        