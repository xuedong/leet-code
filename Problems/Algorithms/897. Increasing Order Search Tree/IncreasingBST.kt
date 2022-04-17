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
    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root?.left == null) {
            root?.right = increasingBST(root?.right)
            return root
        }
        
        val left = increasingBST(root?.left)
        root?.left = null
        var node = left
        while (node?.right != null) {
            node = node?.right
        }
        node?.right = root
        val right = increasingBST(root?.right)
        root?.right = right
        
        return left
    }
}

