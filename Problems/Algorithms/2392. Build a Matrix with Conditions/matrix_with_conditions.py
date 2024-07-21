#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        order_row = self.topology(rowConditions, k)
        order_col = self.topology(colConditions, k)

        if not order_row or not order_col:
            return []

        mat = [[0] * k for _ in range(k)]
        pos_row = {num: i for i, num in enumerate(order_row)}
        pos_col = {num: i for i, num in enumerate(order_col)}

        for num in range(1, k+1):
            if num in pos_row and num in pos_col:
                mat[pos_row[num]][pos_col[num]] = num

        return mat

    def topology(self, edges: List[List[int]], n: int) -> List[int]:
        adj = defaultdict(list)
        for x, y in edges:
            adj[x].append(y)

        visited = [0] * (n+1)
        has_cycle = [False]
        order = []

        for i in range(1, n+1):
            if visited[i] == 0:
                self.dfs(i, adj, visited, order, has_cycle)
                if has_cycle[0]:
                    return []

        order.reverse()
        return order

    def dfs(self, node: int, adj: defaultdict, visited: List[int], order: List[int], has_cycle: List[bool]):
        visited[node] = 1

        for neighbor in adj[node]:
            if visited[neighbor] == 0:
                self.dfs(neighbor, adj, visited, order, has_cycle)
                if has_cycle[0]:
                    return
            elif visited[neighbor] == 1:
                has_cycle[0] = True
                return

        visited[node] = 2
        order.append(node)
