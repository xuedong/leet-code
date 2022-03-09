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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val results = ArrayList<Int>()
        
        if (root != null) {
           results.add(root.`val`)
           results.addAll(preorderTraversal(root.left))
           results.addAll(preorderTraversal(root.right))
        }
        
        return results
    }
}

