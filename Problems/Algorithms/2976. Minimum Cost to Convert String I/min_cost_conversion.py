#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        adj = [[] for _ in range(26)]
        n = len(original)
        for i in range(n):
            adj[ord(original[i]) - ord('a')].append(
                (ord(changed[i]) - ord('a'), cost[i])
            )

        min_costs = [self.dijkstra(i, adj) for i in range(26)]

        ans = 0
        for src, tgt in zip(source, target):
            if src != tgt:
                cost = min_costs[ord(src) - ord('a')][ord(tgt) - ord('a')]
                
                if cost == float("inf"):
                    return -1
                ans += cost

        return ans

    def dijkstra(self, start: int, adj: List[List[tuple]]) -> List[int]:
        pq = [(0, start)]
        costs = [float("inf")] * 26

        while pq:
            curr_cost, curr_char = heapq.heappop(pq)

            if costs[curr_char] != float("inf"):
                continue

            costs[curr_char] = curr_cost
            for target_char, cost in adj[curr_char]:
                total_cost = curr_cost + cost
                
                if costs[target_char] == float("inf"):
                    heapq.heappush(pq, (total_cost, target_char))

        return costs
