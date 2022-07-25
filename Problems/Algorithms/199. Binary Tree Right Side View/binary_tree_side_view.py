# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        results = []
        queue = [root]
        while len(queue) > 0:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)

                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)

                if i == size-1:
                    results.append(curr.val)

        return results

