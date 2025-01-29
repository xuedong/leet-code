#!/usr/bin/env python3

from typing import List


class Solution:
    def __is_connected(self, src, tgt, visited, adj):
        visited[src] = True
        if src == tgt:
            return True

        found = False
        for neighbor in adj[src]:
            if not visited[neighbor]:
                found = found or self.__is_connected(neighbor, tgt, visited, adj)

        return found

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        adj = [[] for _ in range(n)]

        for edge in edges:
            visited = [False] * n

            if self.__is_connected(edge[0]-1, edge[1]-1, visited, adj):
                return edge

            adj[edge[0]-1].append(edge[1]-1)
            adj[edge[1]-1].append(edge[0]-1)

        return []
