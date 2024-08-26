#!/usr/bin/env python3

from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        if root.children is None:
            return [root.val]

        ans = [root.val]
        for child in root.children:
            ans += self.preorder(child)
        return ans
