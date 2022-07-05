#!/usr/bin/env python3

from collections import Counter


class UnionFind:
    def __init__(self):
        self.uf = {}

    def find(self, x: int) -> int:
        if x != self.uf[x]:
            self.uf[x] = self.find(self.uf[x])
        return self.uf[x]

    def union(self, x, y):
        self.uf.setdefault(x, x)
        self.uf.setdefault(y, y)
        self.uf[self.find(y)] = self.find(x)


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        uf = UnionFind()
        num_set = set(nums)
        for num in num_set:
            uf.union(num, num)
            if num - 1 in num_set:
                uf.union(num, num-1)

        counter = Counter()
        for num in num_set:
            counter[uf.find(num)] += 1

        return max(counter.values())

