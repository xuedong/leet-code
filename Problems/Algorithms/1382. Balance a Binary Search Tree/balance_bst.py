#!/usr/bin/env python3

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        inorder = []
        self.inorder_traversal(root, inorder)

        return self.reconstruct_bst(inorder, 0, len(inorder)-1)

    def inorder_traversal(self, root: TreeNode, inorder: List):
        if not root:
            return

        self.inorder_traversal(root.left, inorder)
        inorder.append(root.val)
        self.inorder_traversal(root.right, inorder)

    def reconstruct_bst(self, inorder: List, start: int, end: int) -> TreeNode:
        if start > end:
            return None

        mid = start + (end - start) // 2
        left = self.reconstruct_bst(inorder, start, mid-1)
        right = self.reconstruct_bst(inorder, mid+1, end)

        return TreeNode(inorder[mid], left, right)
