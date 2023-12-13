#!/usr/bin/env python3

from typing import List


class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        def get_column_sum(col):
            return sum(row[col] for row in mat)

        ans = 0
        for row in mat:
            if sum(row) == 1:
                col = row.index(1)
                ans += get_column_sum(col) == 1
        
        return ans
