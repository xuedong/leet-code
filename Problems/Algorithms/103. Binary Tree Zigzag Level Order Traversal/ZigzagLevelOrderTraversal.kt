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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        
        if (root == null) {
            return result
        }
        
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        
        while (!queue.isEmpty()) {
            val len = queue.size
            val curr = mutableListOf<Int>()
            
            for (i in 0..len-1) {
                val node = queue.removeFirst()
                curr.add(node?.`val`!!)
                
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            
            result.add(curr)
        }
        
        for (i in 0..result.size-1) {
            if (i % 2 == 1) {
                result[i] = result[i].reversed()
            }
        }
        
        return result
    }
}

