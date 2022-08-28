#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        diagonals = defaultdict(list)

        n, m = len(mat), len(mat[0])
        for i in range(n):
            for j in range(m):
                diagonals[i-j].append(mat[i][j])

        for k in diagonals:
            diagonals[k].sort()

        for i in range(n):
            for j in range(m):
                mat[i][j] = diagonals[i-j].pop(0)

        return mat
