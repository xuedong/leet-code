#!/usr/bin/env python3

from typing import List


class Solution:
    INF = int(2e9)

    def modifiedGraphEdges(
        self,
        n: int,
        edges: List[List[int]],
        source: int,
        destination: int,
        target: int,
    ) -> List[List[int]]:
        curr = self.dijkstra(edges, n, source, destination)

        if curr < target:
            return []
        
        match = curr == target
        for edge in edges:
            if edge[2] > 0:
                continue

            edge[2] = self.INF if match else 1
            if not match:
                new_distance = self.dijkstra(edges, n, source, destination)

                if new_distance <= target:
                    match = True
                    edge[2] += target - new_distance

        return edges if match else []

    def dijkstra(
        self, edges: List[List[int]], n: int, source: int, destination: int
    ) -> int:
        adj_matrix = [[self.INF] * n for _ in range(n)]
        min_distance = [self.INF] * n
        visited = [False] * n

        min_distance[source] = 0

        for node_a, node_b, weight in edges:
            if weight != -1:
                adj_matrix[node_a][node_b] = weight
                adj_matrix[node_b][node_a] = weight

        for _ in range(n):
            nearest_unvisited_node = -1
            for i in range(n):
                if not visited[i] and (
                    nearest_unvisited_node == -1
                    or min_distance[i] < min_distance[nearest_unvisited_node]
                ):
                    nearest_unvisited_node = i

            visited[nearest_unvisited_node] = True

            for v in range(n):
                min_distance[v] = min(
                    min_distance[v],
                    min_distance[nearest_unvisited_node]
                    + adj_matrix[nearest_unvisited_node][v],
                )

        return min_distance[destination]
