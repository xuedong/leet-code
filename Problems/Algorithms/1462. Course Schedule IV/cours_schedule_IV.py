#!/usr/bin/env python3

from typing import List


class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adj = {i: [] for i in range(numCourses)}

        for prerequisite in prerequisites:
            adj[prerequisite[0]].append(prerequisite[1])

        result = []
        for query in queries:
            visited = [False] * numCourses
            result.append(self.__is_prerequisite(adj, visited, query[0], query[1]))

        return result

    def __is_prerequisite(self, adj: dict, visited: List[bool], src: int, tgt: int) -> bool:
        visited[src] = True

        if src == tgt:
            return True

        for neighbor in adj.get(src, []):
            if not visited[neighbor]:
                if self.__is_prerequisite(adj, visited, neighbor, tgt):
                    return True
        return False
