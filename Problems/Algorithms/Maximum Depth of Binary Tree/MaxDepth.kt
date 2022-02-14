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
        
        var left: Int = 1 + maxDepth(root.left)
        var right: Int = 1 + maxDepth(root.right)
        
        return if (left > right) left else right
    }
}

