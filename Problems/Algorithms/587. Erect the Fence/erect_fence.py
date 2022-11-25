#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        def cross(o, a, b):
            return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
        
        if len(trees) <= 1:
            return []

        trees.sort(key=lambda x: (x[0], x[1]))

        lower = []
        for p in trees:
            while len(lower) >= 2 and cross(lower[-2], lower[-1], p) < 0:
                lower.pop()
            lower.append(p)
        
        upper = []
        for p in reversed(trees):
            while len(upper) >= 2 and cross(upper[-2], upper[-1], p) < 0:
                upper.pop()
            upper.append(p)
        
        res = []
        for tree in lower[:-1] + upper[:-1]:
            if tree not in res:
                res.append(tree)
        return res
