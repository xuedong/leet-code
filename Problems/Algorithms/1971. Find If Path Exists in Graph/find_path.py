#!/usr/bin/env python3

from collections import defaultdict
from typing import List


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = defaultdict(set)
        for edge in edges:
            x, y = edge
            graph[x].add(y)
            graph[y].add(x)

        visited = set()
        queue = [source]
        while len(queue) > 0:
            curr = queue.pop(0)
            if curr not in visited:
                if curr == destination:
                     return True
                for neighbor in graph[curr]:
                    if neighbor not in visited:
                        queue.append(neighbor)
                visited.add(curr)

        return False
