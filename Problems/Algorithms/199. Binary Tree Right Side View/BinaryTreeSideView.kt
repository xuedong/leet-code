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
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        
        if (root == null) return result
        
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        
        while (!queue.isEmpty()) {
            val len = queue.size
            
            for (i in 0..len-1) {
                val node = queue.removeFirst()
                
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
                
                if (i == len-1) {
                    result.add(node?.`val`!!)
                }
            }
        }
        
        return result
    }
}

