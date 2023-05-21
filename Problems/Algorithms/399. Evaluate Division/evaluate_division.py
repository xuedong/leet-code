#!/usr/bin/env python3

from collections import defaultdict
from typing import List


class Solution:
    def dfs(self, node: str, target: str, graph: dict, visited: set, ans: List[float], temp: float) -> None:
        if node in visited:
            return

        visited.add(node)
        if node == target:
            ans[0] = temp
            return

        for neighbor, value in graph[node].items():
            self.dfs(neighbor, target, graph, visited, ans, temp * value)

    def build_graph(self, equations: List[List[str]], values: List[float]) -> dict:
        graph = defaultdict(dict)

        for i in range(len(equations)):
            dividend, divisor = equations[i]
            value = values[i]

            graph[dividend][divisor] = value
            graph[divisor][dividend] = 1.0 / value

        return graph
            
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = self.build_graph(equations, values)
        results = []

        for query in queries:
            dividend, divisor = query

            if dividend not in graph or divisor not in graph:
                results.append(-1.0)
            else:
                visited = set()
                ans = [-1.0]
                temp = 1.0
                self.dfs(dividend, divisor, graph, visited, ans, temp)
                results.append(ans[0])

        return results
