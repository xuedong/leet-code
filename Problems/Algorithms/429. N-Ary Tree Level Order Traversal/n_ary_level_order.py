#!/usr/bin/env python3

from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []

        results = []

        queue = []
        queue.append(root)
        while len(queue) > 0:
            n = len(queue)
            level = []

            for i in range(n):
                curr = queue.pop(0)
                level.append(curr.val)
                for child in curr.children:
                    queue.append(child)

            results.append(level)

        return results
