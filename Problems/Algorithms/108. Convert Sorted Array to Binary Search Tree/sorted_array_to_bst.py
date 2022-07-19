# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def aux(nums: List[int], start: int, end: int) -> Optional[TreeNode]:
            if start > end:
                return None

            mid = start + (end - start) // 2
            root = TreeNode(nums[mid])

            left, right = aux(nums, start, mid-1), aux(nums, mid+1, end)
            root.left, root.right = left, right

            return root

        return aux(nums, 0, len(nums)-1)

