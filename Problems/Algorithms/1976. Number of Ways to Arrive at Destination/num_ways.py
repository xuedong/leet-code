#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        mod = 1_000_000_007

        graph = [[] for _ in range(n)]
        for src, dst, time in roads:
            graph[src].append((dst, time))
            graph[dst].append((src, time))

        heap = [(0, 0)]
        shortest = [float("inf")] * n
        counts = [0] * n

        shortest[0] = 0
        counts[0] = 1

        while heap:
            curr_time, curr = heapq.heappop(heap)
            if curr_time > shortest[curr]:
                continue

            for neighbor, time in graph[curr]:
                if curr_time + time < shortest[neighbor]:
                    shortest[neighbor] = curr_time + time
                    counts[neighbor] = counts[curr]

                    heapq.heappush(heap, (shortest[neighbor], neighbor))
                elif curr_time + time == shortest[neighbor]:
                    counts[neighbor] = (counts[neighbor] + counts[curr]) % mod

        return counts[n-1]
