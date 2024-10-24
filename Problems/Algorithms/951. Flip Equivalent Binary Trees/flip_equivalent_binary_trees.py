#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def find_canonical(self, root: TreeNode) -> None:
        if not root:
            return

        self.find_canonical(root.left)
        self.find_canonical(root.right)

        if not root.right:
            return

        if not root.left:
            root.left = root.right
            root.right = None
            return

        left = root.left
        right = root.right

        if left.val > right.val:
            root.left, root.right = root.right, root.left

    def equivalent(self, root1: TreeNode, root2: TreeNode) -> bool:
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False
        if root1.val != root2.val:
            return False

        return self.equivalent(root1.left, root2.left) and self.equivalent(root1.right, root2.right)

    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        self.find_canonical(root1)
        self.find_canonical(root2)
        return self.equivalent(root1, root2)
