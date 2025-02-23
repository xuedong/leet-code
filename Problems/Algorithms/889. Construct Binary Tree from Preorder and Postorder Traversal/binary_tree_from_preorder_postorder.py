#!/usr/bin/env python3

from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(preorder)
        return self.__construct(0, n-1, 0, preorder, postorder)

    def __construct(
        self,
        pre_start: int,
        pre_end: int,
        post_start: int,
        preorder: List[int],
        postorder: List[int],
    ) -> Optional[TreeNode]:
        if pre_start > pre_end:
            return None

        if pre_start == pre_end:
            return TreeNode(preorder[pre_start])

        left = preorder[pre_start+1]
        n = 1
        while postorder[post_start+n-1] != left:
            n += 1
        
        root = TreeNode(preorder[pre_start])
        root.left = self.__construct(pre_start+1, pre_start+n, post_start, preorder, postorder)
        root.right = self.__construct(pre_start+n+1, pre_end, post_start+n, preorder, postorder)

        return root
