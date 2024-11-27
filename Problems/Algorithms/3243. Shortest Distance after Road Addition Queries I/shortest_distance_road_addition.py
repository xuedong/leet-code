#!/usr/bin/env python3

from typing import List


class Solution:
    def find(self, adj, n, curr, dp):
        if curr == n-1:
            return 0

        if dp[curr] != -1:
            return dp[curr]

        min_dist = n
        for neighbor in adj[curr]:
            min_dist = min(min_dist, self.find(adj, n, neighbor, dp) + 1)

        dp[curr] = min_dist
        return min_dist

    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        dp = [-1] * n
        adj = [[] for _ in range(n)]

        for i in range(n-1):
            adj[i].append(i+1)

        ans = []
        for road in queries:
            u, v = road[0], road[1]
            adj[u].append(v)

            ans.append(self.find(adj, n, 0, dp))

            dp = [-1] * n
            
        return ans
