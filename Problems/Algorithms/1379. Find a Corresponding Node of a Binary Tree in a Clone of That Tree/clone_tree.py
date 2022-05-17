# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None

    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        def inorder(original: TreeNode, cloned: TreeNode):
            if original is not None:
                inorder(original.left, cloned.left)
                if original == target:
                    self.ans = cloned
                inorder(original.right, cloned.right)

        inorder(original, cloned)
        return self.ans

