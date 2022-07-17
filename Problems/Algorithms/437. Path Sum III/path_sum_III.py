# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans = 0

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def check(node, target):
            if node is None:
                return
            if node.val == target:
                self.ans += 1

            check(node.left, target-node.val)
            check(node.right, target-node.val)

        def dfs(node, target):
            if node is None:
                return

            check(node, target)
            dfs(node.left, target)
            dfs(node.right, target)

        dfs(root, targetSum)
        return self.ans

