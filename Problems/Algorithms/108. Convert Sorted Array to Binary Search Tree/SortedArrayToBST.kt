/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        val n = nums.size
        if (n == 1) return TreeNode(nums[0])
        if (n == 2) {
            val tree = TreeNode(nums[1])
            tree.left = TreeNode(nums[0])
            return tree
        }
        if (n == 3) {
            val tree = TreeNode(nums[1])
            tree.left = TreeNode(nums[0])
            tree.right = TreeNode(nums[2])
            return tree
        }
        
        val mid = (nums.size - 1) / 2
        
        val leftTree = sortedArrayToBST(nums.copyOfRange(0, mid))
        val rightTree = sortedArrayToBST(nums.copyOfRange(mid+1, nums.size))
        
        val tree = TreeNode(nums[mid])
        tree?.left = leftTree
        tree?.right = rightTree
        
        return tree
    }
}

