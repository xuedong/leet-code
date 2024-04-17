#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        self.smallest = ""
        self.dfs(root, "")
        return self.smallest
        
    def dfs(self, node, curr):
        if not node:
            return

        curr = chr(node.val + ord('a')) + curr

        if not node.left and not node.right:
            if not self.smallest or self.smallest > curr:
                self.smallest = curr

        if node.left:
            self.dfs(node.left, curr)
        if node.right:
            self.dfs(node.right, curr)
