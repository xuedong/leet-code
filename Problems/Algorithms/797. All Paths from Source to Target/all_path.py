#!/usr/bin/env python3

from typing import List


class Solution:
    def __init__(self):
        self.results = []
        self.path = []

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        self.path.append(0)
        self.helper(graph, 0, len(graph)-1)
        return self.results
    
    def helper(self, graph: List[List[int]], src: int, target: int):
        if src == target:
            self.results.append(self.path.copy())
            return

        if len(graph[src]) == 0:
            return

        for neighbor in graph[src]:
            self.path.append(neighbor)
            self.helper(graph, neighbor, target)
            self.path.pop()
