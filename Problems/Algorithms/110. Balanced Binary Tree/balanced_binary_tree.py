# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def aux(node: Optional[TreeNode]) -> Tuple[bool, int]:
            if node is None:
                return True, 0

            flag_left, height_left = aux(node.left)
            flag_right, height_right = aux(node.right)
            return (flag_left and flag_right and abs(height_left-height_right) <= 1), 1+max(height_left, height_right)

        return aux(root)[0]

