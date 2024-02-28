#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        self.max_depth = -1
        self.bottom_left = 0

        def dfs(node, depth):
            if not node:
                return

            if depth > self.max_depth:
                self.max_depth = depth
                self.bottom_left = node.val

            dfs(node.left, depth+1)
            dfs(node.right, depth+1)
            return

        dfs(root, 0)
        return self.bottom_left
