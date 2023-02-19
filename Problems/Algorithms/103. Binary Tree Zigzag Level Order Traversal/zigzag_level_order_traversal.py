#!/usr/bin/env python3

from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root is None:
            return result
        
        queue = [root]
        while len(queue) > 0:
            length = len(queue)
            curr = []
            
            for i in range(length):
                node = queue.pop(0)
                curr.append(node.val)
                
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            
            result.append(curr)
        
        for i in range(len(result)):
            if i % 2 == 1:
                result[i] = result[i][::-1]
        
        return result
