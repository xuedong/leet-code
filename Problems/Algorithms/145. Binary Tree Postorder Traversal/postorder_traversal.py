#!/usr/bin/env python3

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def helper(curr, res):
            if not curr:
                return

            helper(curr.left, res)
            helper(curr.right, res)
            res.append(curr.val)

        res = []
        helper(root, res)
        return res
