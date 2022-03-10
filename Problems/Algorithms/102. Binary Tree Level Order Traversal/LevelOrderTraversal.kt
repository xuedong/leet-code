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
        if (root == null) return listOf()
        
        val ans = mutableListOf<MutableList<Int>>()
        
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val len = queue.size
            val current = mutableListOf<Int>()
            for (i in 0..len-1) {
                val node = queue.removeFirst()
                current.add(node?.`val`!!)
                
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            
            ans.add(current)
        }
        
        return ans
    }
}

