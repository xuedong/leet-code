#!/usr/bin/env python3

from typing import Optional, Dict, Set
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        tree_map: Dict[int, Set[int]] = {}
        self.graph(root, 0, tree_map)

        queue = deque([start])
        ans = 0
        visited = {start}

        while queue:
            size = len(queue)
            while size > 0:
                current = queue.popleft()
                for num in tree_map[current]:
                    if num not in visited:
                        visited.add(num)
                        queue.append(num)
                size -= 1
            ans += 1

        return ans - 1

    def graph(self, current: TreeNode, parent: int, tree_map: Dict[int, Set[int]]):
        if current is None:
            return

        if current.val not in tree_map:
            tree_map[current.val] = set()
        adjacent_list = tree_map[current.val]
        if parent != 0:
            adjacent_list.add(parent)
        if current.left:
            adjacent_list.add(current.left.val)
        if current.right:
            adjacent_list.add(current.right.val)

        self.graph(current.left, current.val, tree_map)
        self.graph(current.right, current.val, tree_map)
