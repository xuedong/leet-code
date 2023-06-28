#!/usr/bin/env python3

from typing import List


class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        proba = [0] * n
        proba[start] = 1

        for i in range(n-1):
            flag = False
            for j in range(len(edges)):
                u, v = edges[j]
                path_proba = succProb[j]
                if proba[u] * path_proba > proba[v]:
                    proba[v] = proba[u] * path_proba
                    flag = True
                if proba[v] * path_proba > proba[u]:
                    proba[u] = proba[v] * path_proba
                    flag = True
            if not flag:
                break

        return proba[end]
