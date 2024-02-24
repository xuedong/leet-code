#!/usr/bin/env python3

from typing import List
from collections import defaultdict, deque
from math import inf


class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        graph = defaultdict(list)
        for x, y, t in meetings:
            graph[x].append((t, y))
            graph[y].append((t, x))

        times = [inf] * n
        times[0] = 0
        times[firstPerson] = 0

        queue = deque()
        queue.append((0, 0))
        queue.append((firstPerson, 0))

        while queue:
            person, time = queue.popleft()

            for neighbor_time, neighbor in graph[person]:
                if neighbor_time >= time and times[neighbor] > neighbor_time:
                    times[neighbor] = neighbor_time
                    queue.append((neighbor, neighbor_time))

        return [i for i in range(n) if times[i] != inf]
