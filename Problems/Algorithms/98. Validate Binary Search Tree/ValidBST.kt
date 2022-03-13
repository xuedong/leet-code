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
    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
    
    private fun isValid(root: TreeNode?, minValue: Long, maxValue: Long): Boolean {
        if (root == null) return true
        
        if (root?.`val`.toLong() > minValue && root?.`val`.toLong() < maxValue) {
            return isValid(root?.left, minValue, root?.`val`.toLong()) && isValid(root?.right, root?.`val`.toLong(), maxValue) 
        }
        return false
    }
}

