#!/usr/bin/env python3


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        def post_order(curr, distance):
            if curr is None:
                return [0] * 12
            elif curr.left is None and curr.right is None:
                res = [0] * 12
                res[0] = 1
                return res

            left = post_order(curr.left, distance)
            right = post_order(curr.right, distance)
            
            res = [0] * 12
            for i in range(10):
                res[i+1] += left[i] + right[i]

            res[11] = left[11] + right[11]
            for d1 in range(distance+1):
                for d2 in range(distance+2):
                    if d1 + d2 + 2 <= distance:
                        res[11] += left[d1] * right[d2]
            return res

        return post_order(root, distance)[11]
