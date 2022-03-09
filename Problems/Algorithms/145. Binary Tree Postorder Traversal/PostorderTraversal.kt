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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val results = ArrayList<Int>()
        
        if (root != null) {
           results.addAll(postorderTraversal(root.left))
           results.addAll(postorderTraversal(root.right))
           results.add(root.`val`)
        }
        
        return results
    }
}

