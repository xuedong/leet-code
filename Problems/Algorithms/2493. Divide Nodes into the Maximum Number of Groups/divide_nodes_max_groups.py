#!/usr/bin/env python3

from collections import deque
from typing import List


class Solution:
    def __is_bipartite(self, adj, node, colors):
        for neighbor in adj[node]:
            if colors[neighbor] == colors[node]:
                return False
            
            if colors[neighbor] != -1:
                continue

            colors[neighbor] = (colors[node] + 1) % 2
            if not self.__is_bipartite(adj, neighbor, colors):
                return False
        return True

    def __get_height(self, adj, src, n):
        visited = [False] * n
        visited[src] = True

        height = 0
        queue = deque([src])
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()

                for neighbor in adj[curr]:
                    if visited[neighbor]:
                        continue
                    visited[neighbor] = True
                    queue.append(neighbor)

            height += 1
        
        return height

    def __get_splits(self, adj, node, heights, visited):
        groups = heights[node]
        visited[node] = True

        for neighbor in adj[node]:
            if visited[neighbor]:
                continue

            groups = max(groups, self.__get_splits(adj, neighbor, heights, visited))

        return groups

    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        adj = [[] for _ in range(n)]
        for edge in edges:
            adj[edge[0]-1].append(edge[1]-1)
            adj[edge[1]-1].append(edge[0]-1)

        colors = [-1] * n
        for node in range(n):
            if colors[node] != -1:
                continue
            
            colors[node] = 0
            if not self.__is_bipartite(adj, node, colors):
                return -1

        heights = [self.__get_height(adj, node, n) for node in range(n)]

        groups = 0
        visited = [False] * n
        for node in range(n):
            if visited[node]:
                continue

            groups += self.__get_splits(adj, node, heights, visited)

        return groups
