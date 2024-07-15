#!/usr/bin/env python3

from typing import List, Optional
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        children, parents = set(), set()
        tree = {}

        for des in descriptions:
            parent, child, is_left = des
            parents.add(parent)
            parents.add(child)
            children.add(child)

            if parent not in tree:
                tree[parent] = []
            tree[parent].append((child, is_left))

        for parent in parents.copy():
            if parent in children:
                parents.remove(parent)

        root = TreeNode(next(iter(parents)))
        queue = deque([root])

        while queue:
            parent = queue.popleft()
            for val, is_left in tree.get(parent.val, []):
                child = TreeNode(val)
                queue.append(child)

                if is_left == 1:
                    parent.left = child
                else:
                    parent.right = child

        return root
