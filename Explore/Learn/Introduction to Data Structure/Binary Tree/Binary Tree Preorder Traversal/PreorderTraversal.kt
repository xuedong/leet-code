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
    val res = mutableListOf<Int>()
    
    fun aux(node: TreeNode?) {
        if (node == null) return;
        res.add(node.`val`)
        aux(node.left)
        aux(node.right)
    }
    
    fun preorderTraversal(root: TreeNode?): List<Int> {
        aux(root)
        return res
    }
}

