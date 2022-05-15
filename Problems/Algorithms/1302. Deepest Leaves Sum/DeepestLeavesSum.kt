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
    fun deepestLeavesSum(root: TreeNode?): Int {
        return root?.let { aux(it, height(it)) } ?: 0
    }
    
    private fun aux(root: TreeNode?, h: Int): Int {
        return root?.let {
            if (h == 1) it.`val` else aux(it.left, h-1) + aux(it.right, h-1)
        } ?: 0
    }
    
    private fun height(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + maxOf(height(root!!.left), height(root!!.right))
    }
}

