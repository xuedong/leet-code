#!/usr/bin/env python3

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.index = 0

    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        return self.__helper(traversal, 0)

    def __helper(self, traversal: str, depth: int):
        if self.index >= len(traversal):
            return None

        count = 0
        while self.index + count < len(traversal) and traversal[self.index + count] == "-":
            count += 1
        if count != depth:
            return None

        self.index += count

        value = 0
        while self.index < len(traversal) and traversal[self.index].isdigit():
            value = value * 10 + int(traversal[self.index])
            self.index += 1

        node = TreeNode(value)
        node.left = self.__helper(traversal, depth+1)
        node.right = self.__helper(traversal, depth+1)

        return node
