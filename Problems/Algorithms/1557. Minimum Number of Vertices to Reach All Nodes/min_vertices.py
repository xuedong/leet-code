import numpy as np


class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        ins = [0 for _ in range(n)]

        for edge in edges:
            ins[edge[1]] += 1

        return np.where(np.array(ins) == 0)[0]

