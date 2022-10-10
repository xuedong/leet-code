#!/usr/bin/env python3
# coding: utf-8

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        def dfs(node):
            if node:
                if k - node.val in seen:
                    return True
                seen.add(node.val)
                return dfs(node.left) or dfs(node.right)
            return False

        seen = set()
        return dfs(root)
