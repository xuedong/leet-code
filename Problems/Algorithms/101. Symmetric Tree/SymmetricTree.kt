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
    private fun aux(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        } else if (left == null && right != null) {
            return false
        } else if (left != null && right == null) {
            return false
        } else if (left?.`val` != right?.`val`) {
            return false
        } else {
            return aux(left?.left, right?.right) && aux(left?.right, right?.left)
        }
    }
    
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        } else {
            return aux(root.left, root.right)
        }
    }
}

