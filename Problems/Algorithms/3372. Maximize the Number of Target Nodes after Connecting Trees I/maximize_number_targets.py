#!/usr/bin/env python3

from typing import List


class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        def dfs(node: int, parent: int, children: List[List[int]], k: int) -> int:
            if k < 0:
                return 0

            res = 1
            for child in children[node]:
                if child == parent:
                    continue
                res += dfs(child, node, children, k-1)
            return res

        def build(edges: List[List[int]], k: int) -> List[int]:
            n = len(edges) + 1
            children = [[] for _ in range(n)]
            for u, v in edges:
                children[u].append(v)
                children[v].append(u)

            res = [0] * n
            for i in range(n):
                res[i] = dfs(i, -1, children, k)
            return res

        count1 = build(edges1, k)
        count2 = build(edges2, k-1)
        count = max(count2)
        res = [count1[i] + count for i in range(len(edges1) + 1)]
        return res
