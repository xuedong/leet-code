#!/usr/bin/env python3

from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        def helper(node, postorder_list):
            if not node:
                return

            for child in node.children:
                helper(child, postorder_list)
            postorder_list.append(node.val)

        res = []
        if not root:
            return res

        helper(root, res)
        return res
