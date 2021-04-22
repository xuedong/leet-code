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
    fun partial(node: TreeNode?, targetSum: Int): Boolean {
        if (node == null) return false
        if (node?.`val` == targetSum && node?.left == null && node?.right == null) return true
        
        val newSum = targetSum - node?.`val`
        if (node?.left == null) {
            return partial(node?.right, newSum)
        }
        if (node?.right == null) {
            return partial(node?.left, newSum)
        }
        return partial(node!!.left, newSum) || partial(node!!.right, newSum)
    }
    
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return partial(root, targetSum)
    }
}

