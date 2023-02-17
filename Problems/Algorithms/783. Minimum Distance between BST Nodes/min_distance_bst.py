#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.res = 1e5
        self.pre = -1e5

    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        if root.left is not None:
            self.minDiffInBST(root.left)
        self.res = min(self.res, root.val-self.pre)
        self.pre = root.val
        if root.right is not None:
            self.minDiffInBST(root.right)
        return self.res
