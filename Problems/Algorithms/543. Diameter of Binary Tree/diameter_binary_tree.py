# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def height(node: Optional[TreeNode]) -> int:
            if node is None or (node.left is None and node.right is None):
                return 0

            left, right = height(node.left), height(node.right)
            return max(left, right) + 1

        if root is None:
            return 0
        if root.left is None:
            return max(height(root), self.diameterOfBinaryTree(root.right))
        if root.right is None:
            return max(height(root), self.diameterOfBinaryTree(root.left))
        return max(2 + height(root.left) + height(root.right), self.diameterOfBinaryTree(root.left), self.diameterOfBinaryTree(root.right))

