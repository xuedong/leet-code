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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        
        val output = mutableListOf<MutableList<Int>>()
        val queue = mutableListOf<TreeNode>()
        
        queue.add(root)
        while (queue.size > 0) {
            val curr = mutableListOf<Int>()
            for (i in 1..queue.size) {
                val node = queue.removeAt(0)
                curr.add(node.`val`)
                
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
            }
            output.add(curr)
        }
        
        return output
    }
}

