#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def __init__(self):
        self.bob_path = {}
        self.visited = []
        self.tree = []

    def __find_bob_path(self, src, time):
        self.bob_path[src] = time
        self.visited[src] = True

        if src == 0:
            return True

        for adj in self.tree[src]:
            if not self.visited[adj]:
                if self.__find_bob_path(adj, time+1):
                    return True

        self.bob_path.pop(src, None)
        return False

    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        n = len(amount)

        self.tree = [[] for _ in range(n)]
        for edge in edges:
            self.tree[edge[0]].append(edge[1])
            self.tree[edge[1]].append(edge[0])

        self.bob_path = {}
        self.visited = [False] * n
        self.__find_bob_path(bob, 0)

        ans = float("-inf")
        queue = deque([(0, 0, 0)])
        self.visited = [False] * n
        while queue:
            src, time, income = queue.popleft()

            if src not in self.bob_path or time < self.bob_path[src]:
                income += amount[src]
            elif time == self.bob_path[src]:
                income += amount[src] // 2

            if len(self.tree[src]) == 1 and src != 0:
                ans = max(ans, income)

            for adj in self.tree[src]:
                if not self.visited[adj]:
                    queue.append((adj, time+1, income))

            self.visited[src] = True

        return ans
