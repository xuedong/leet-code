#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, ans):
            if not node:
                return 0

            ans = ans * 10 + node.val
            if not node.left and not node.right:
                return ans
            return dfs(node.left, ans) + dfs(node.right, ans)

        return dfs(root, 0)
