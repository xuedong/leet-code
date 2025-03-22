#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for vertex in range(n):
            graph[vertex] = [vertex]
        for v1, v2 in edges:
            graph[v1].append(v2)
            graph[v2].append(v1)

        freqs = defaultdict(int)
        for vertex in range(n):
            neighbors = tuple(sorted(graph[vertex]))
            freqs[neighbors] += 1

        return sum(1 for neighbors, freq in freqs.items() if len(neighbors) == freq)
