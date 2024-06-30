#!/usr/bin/env python3

from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = list(range(n+1))
        self.sizes = [1] * (n+1)
        self.components = n

    def find(self, x):
        if self.root[x] == x:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x == root_y:
            return 0

        if self.sizes[root_x] > self.sizes[root_y]:
            self.sizes[root_x] += self.sizes[root_y]
            self.root[root_y] = root_x
        else:
            self.sizes[root_y] += self.sizes[root_x]
            self.root[root_x] = root_y

        self.components -= 1
        return 1

    def is_connected(self):
        return self.components == 1


class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        alice = UnionFind(n)
        bob = UnionFind(n)

        edges_required = 0
        for edge in edges:
            if edge[0] == 3:
                edges_required += (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]))

        for edge in edges:
            if edge[0] == 2:
                edges_required += bob.union(edge[1], edge[2])
            elif edge[0] == 1:
                edges_required += alice.union(edge[1], edge[2])

        if alice.is_connected() and bob.is_connected():
            return len(edges) - edges_required

        return -1
