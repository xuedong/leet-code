# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        results = []

        def traverse(root: Optional[TreeNode]):
            if root is None:
                return

            traverse(root.left)
            results.append(root.val)
            traverse(root.right)

        traverse(root)
        return results[k-1]

