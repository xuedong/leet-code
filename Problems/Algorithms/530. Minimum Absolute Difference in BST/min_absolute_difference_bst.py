#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        node_values = []

        def dfs(node):
            if node is None:
                return
            node_values.append(node.val)
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)

        node_values.sort()
        min_difference = 1e9
        for i in range(1, len(node_values)):
            min_difference = min(min_difference, node_values[i] - node_values[i-1])

        return min_difference
