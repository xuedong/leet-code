#!/usr/bin/env python3

from typing import List


class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        adj = [[] for _ in range(n)]
        for edge in edges:
            from_node, to_node = edge
            adj[to_node].append(from_node)

        ancestors_list = []
        for i in range(n):
            ancestors = []
            visited = set()
            self.find(i, adj, visited)

            for node in range(n):
                if node == i:
                    continue
                if node in visited:
                    ancestors.append(node)

            ancestors_list.append(ancestors)

        return ancestors_list

    def find(self, node, adj, visited):
        visited.add(node)

        for neighbor in adj[node]:
            if neighbor not in visited:
                self.find(neighbor, adj, visited)
