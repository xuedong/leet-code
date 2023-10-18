#!/usr/bin/env python3

from collections import defaultdict, deque
from typing import List


class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        graph = defaultdict(list)
        indegree = [0] * n
        for (x, y) in relations:
            graph[x-1].append(y-1)
            indegree[y-1] += 1

        queue = deque()
        times = [0] * n
        for node in range(n):
            if indegree[node] == 0:
                queue.append(node)
                times[node] = time[node]

        while queue:
            curr = queue.popleft()
            for neighbor in graph[curr]:
                times[neighbor] = max(times[neighbor], times[curr] + time[neighbor])
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)

        return max(times)
