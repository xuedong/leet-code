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
    private lateinit var result: MutableList<Int>
    
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        result = mutableListOf<Int>()
        
        aux(root, k)
        
        return result[k-1]
    }
    
    private fun aux(node: TreeNode?, k: Int): Unit {
        if (result.size >= k || node == null) return
        
        aux(node?.left, k)
        result.add(node?.`val`)
        aux(node?.right, k)
    }
}

