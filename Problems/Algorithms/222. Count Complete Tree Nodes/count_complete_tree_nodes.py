#!/usr/bin/env python3
# coding: utf-8

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        left_depth = self.get_depth(root.left)
        right_depth = self.get_depth(root.right)
        if left_depth == right_depth:
            return 2 ** left_depth + self.countNodes(root.right)
        else:
            return 2 ** right_depth + self.countNodes(root.left)

    def get_depth(self, root: Optional[TreeNode]) -> int:
        depth = 0
        while root:
            depth += 1
            root = root.left
        return depth
