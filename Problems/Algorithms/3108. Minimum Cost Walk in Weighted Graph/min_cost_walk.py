#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        adj_list = [[] for _ in range(n)]
        for edge in edges:
            adj_list[edge[0]].append((edge[1], edge[2]))
            adj_list[edge[1]].append((edge[0], edge[2]))

        visited = [False] * n

        components = [0] * n
        component_cost = []

        component_id = 0

        for node in range(n):
            if not visited[node]:
                component_cost.append(
                    self.__get_component_cost(
                        node, adj_list, visited, components, component_id
                    )
                )
                component_id += 1

        result = []
        for query in queries:
            start, end = query

            if components[start] == components[end]:
                result.append(component_cost[components[start]])
            else:
                result.append(-1)

        return result

    def __get_component_cost(
        self, source, adj_list, visited, components, component_id
    ):
        nodes_queue = deque()
        component_cost = -1

        nodes_queue.append(source)
        visited[source] = True

        while nodes_queue:
            node = nodes_queue.popleft()
            components[node] = component_id

            for neighbor, weight in adj_list[node]:
                component_cost &= weight

                if visited[neighbor]:
                    continue
                visited[neighbor] = True
                nodes_queue.append(neighbor)

        return component_cost
