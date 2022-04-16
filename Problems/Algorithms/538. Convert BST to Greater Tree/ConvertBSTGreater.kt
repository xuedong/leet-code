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
    private var sum = 0
    
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root != null) {
            convertBST(root?.right)
            sum += root?.`val`
            root?.`val` = sum
            convertBST(root?.left)
        }
        
        return root
    }
}

