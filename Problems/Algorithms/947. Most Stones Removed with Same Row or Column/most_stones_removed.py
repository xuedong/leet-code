from typing import List


class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n
        self.set_count = n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        fx, fy = self.find(x), self.find(y)
        if fx == fy:
            return False

        if self.size[fx] < self.size[fy]:
            fx, fy = fy, fx
        self.parent[fy] = fx
        self.size[fx] += self.size[fy]
        self.set_count -= 1
        return True

class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        uf = UnionFind(n)
        for i in range(n):
            for j in range(i + 1, n):
                if stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]:
                    uf.union(i, j)

        used = {}
        for i in range(n):
            root = uf.find(i)
            if root not in used:
                used[root] = 1
        
        return n - len(used)
