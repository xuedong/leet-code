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
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        if (leftDepth >= rightDepth) {
            return leftDepth + 1
        } else {
            return rightDepth + 1
        }
    }
}

