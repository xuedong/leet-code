# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def aux(root: Optional[TreeNode], min_value: int, max_value: int) -> bool:
            if root is None:
                return True

            if root.val > min_value and root.val < max_value:
                return aux(root.left, min_value, root.val) and aux(root.right, root.val, max_value)
            return False

        return aux(root, -2e31, 2e31)

