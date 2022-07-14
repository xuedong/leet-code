#!/usr/bin/env python3

from typing import List, Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def aux(preorder: List[int], pre_left: int, pre_right: int, inorder: List[int], in_left: int, in_right: int) -> Optional[TreeNode]:
            if pre_left > pre_right:
                return None

            root = TreeNode(preorder[pre_left])
            for i in range(in_left, in_right+1):
                if inorder[i] == root.val:
                    root.left = aux(preorder, pre_left+1, pre_left+i-in_left, inorder, in_left, i-1)
                    root.right = aux(preorder, pre_left+i-in_left+1, pre_right, inorder, i+1, in_right)
                    break
            return root

        n = len(preorder)
        return aux(preorder, 0, n-1, inorder, 0, n-1)

