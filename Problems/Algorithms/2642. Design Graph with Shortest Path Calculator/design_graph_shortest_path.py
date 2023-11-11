#!/usr/bin/env python3

from typing import List
from heapq import heappop, heappush
from math import inf


class Graph:
    def __init__(self, n: int, edges: List[List[int]]):
        self.adj = [[] for _ in range(n)]
        for start, end, cost in edges:
            self.adj[start].append((end, cost))

    def addEdge(self, edge: List[int]) -> None:
        start, end, cost = edge
        self.adj[start].append((end, cost))

    def shortestPath(self, node1: int, node2: int) -> int:
        n = len(self.adj)

        pq = [(0, node1)]
        costs = [inf] * n
        costs[node1] = 0

        while pq:
            curr_cost, curr_node = heappop(pq)
            
            if curr_cost > costs[curr_node]:
                continue

            if curr_node == node2:
                return curr_cost

            for neighbor, cost in self.adj[curr_node]:
                new_cost = curr_cost + cost
                if new_cost < costs[neighbor]:
                    costs[neighbor] = new_cost
                    heappush(pq, (new_cost, neighbor))
        
        return -1

# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)