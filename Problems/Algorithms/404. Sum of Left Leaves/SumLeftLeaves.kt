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
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        if (root?.left == null) return sumOfLeftLeaves(root?.right)
        if (root?.left?.left == null && root?.left?.right == null) {
            return root?.left?.`val`!! + sumOfLeftLeaves(root?.right)
        }
        return sumOfLeftLeaves(root?.left) + sumOfLeftLeaves(root?.right)
    }
}

