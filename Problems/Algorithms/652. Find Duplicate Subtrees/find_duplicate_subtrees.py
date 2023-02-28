#!/usr/bin/env python3

from typing import Optional, List
from collections import defaultdict


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        def traverse(node):
            if not node:
                return ""

            representation = "(" + traverse(node.left) + ")" + str(node.val) + "(" + traverse(node.right) + ")"
            count[representation] += 1
            if count[representation] == 2:
                result.append(node)
            return representation
        
        count = defaultdict(int)
        result = []
        traverse(root)
        return result
