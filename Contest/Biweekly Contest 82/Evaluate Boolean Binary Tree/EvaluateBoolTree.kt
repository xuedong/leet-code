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
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root?.left == null && root?.right == null) {
            if (root?.`val` == 0) return false
            return true
        }
        if (root?.`val` == 2) {
            return evaluateTree(root?.left) || evaluateTree(root?.right)
        }
        return evaluateTree(root?.left) && evaluateTree(root?.right)
    }
}

