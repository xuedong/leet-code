#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0

        def dfs(curr):
            if curr == None:
                return 0

            left = dfs(curr.left)
            right = dfs(curr.right)

            self.moves += abs(left) + abs(right)
            return curr.val - 1 + left + right

        dfs(root)
        return self.moves
