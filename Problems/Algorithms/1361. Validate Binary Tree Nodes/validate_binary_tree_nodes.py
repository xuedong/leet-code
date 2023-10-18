#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        def find_root():
            children = set(leftChild) | set(rightChild)

            for i in range(n):
                if i not in children:
                    return i

            return -1

        root = find_root()
        if root == -1:
            return False

        visited = {root}
        queue = deque([root])
        while queue:
            node = queue.popleft()
            for child in [leftChild[node], rightChild[node]]:
                if child != -1:
                    if child in visited:
                        return False

                    queue.append(child)
                    visited.add(child)

        return len(visited) == n
