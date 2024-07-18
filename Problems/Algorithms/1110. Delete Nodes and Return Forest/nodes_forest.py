#!/usr/bin/env python3

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        def helper(node, deletion, forest):
            if not node:
                return None

            node.left = helper(node.left, deletion, forest)
            node.right = helper(node.right, deletion, forest)

            if node.val in deletion:
                if node.left:
                    forest.append(node.left)
                if node.right:
                    forest.append(node.right)
                return None
            
            return node

        deletion = set(to_delete)
        forest = []

        root = helper(root, deletion, forest)
        if root:
            forest.append(root)
        return forest
