#!/usr/bin/env python3

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        max_heights = [0] * 100001
        self.curr = 0

        def left_to_right(node, curr):
            if not node:
                return

            max_heights[node.val] = self.curr
            self.curr = max(self.curr, curr)

            left_to_right(node.left, curr+1)
            left_to_right(node.right, curr+1)

        def right_to_left(node, curr):
            if not node:
                return

            max_heights[node.val] = max(max_heights[node.val], self.curr)
            self.curr = max(self.curr, curr)

            right_to_left(node.right, curr+1)
            right_to_left(node.left, curr+1)

        left_to_right(root, 0)
        self.curr = 0
        right_to_left(root, 0)

        return [max_heights[query] for query in queries]
