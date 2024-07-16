#!/usr/bin/env python3

from typing import Optional
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        start = self.find_start(root, startValue)
        
        parents = {}
        self.populate_parents(root, parents)

        visited = set()
        visited.add(start)

        dq = deque([start])
        tracker = {}
        while dq:
            curr = dq.popleft()
            if curr.val == destValue:
                return self.backtrack(curr, tracker)

            if curr.val in parents:
                parent = parents[curr.val]
                if parent not in visited:
                    dq.append(parent)
                    tracker[parent] = (curr, "U")
                    visited.add(parent)

            if curr.left and curr.left not in visited:
                dq.append(curr.left)
                tracker[curr.left] = (curr, "L")
                visited.add(curr.left)

            if curr.right and curr.right not in visited:
                dq.append(curr.right)
                tracker[curr.right] = (curr, "R")
                visited.add(curr.right)

        return ""

    def backtrack(self, node, tracker):
        path = []
        while node in tracker:
            path.append(tracker[node][1])
            node = tracker[node][0]
        
        path.reverse()
        return "".join(path)

    def populate_parents(self, node, parents):
        if not node:
            return

        if node.left:
            parents[node.left.val] = node
            self.populate_parents(node.left, parents)

        if node.right:
            parents[node.right.val] = node
            self.populate_parents(node.right, parents)

    def find_start(self, node, start):
        if not node:
            return None

        if node.val == start:
            return node

        left = self.find_start(node.left, start)
        if left:
            return left
        return self.find_start(node.right, start)
