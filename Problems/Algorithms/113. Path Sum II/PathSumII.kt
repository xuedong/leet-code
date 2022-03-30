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
    private lateinit var result: MutableList<MutableList<Int>>
    
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        result = mutableListOf<MutableList<Int>>()
        if (root == null) return result
        
        partial(root, targetSum, mutableListOf<Int>())
        return result
    }
    
    private fun partial(node: TreeNode?, sum: Int, visited: MutableList<Int>) {
        if (node == null) return
        
        visited.add(node?.`val`)
        if (node?.`val` == sum && node?.left == null && node?.right == null) {
            result.add(visited.toMutableList())
            visited.removeAt(visited.size-1)
            return
        }
        
        partial(node?.left, sum-node?.`val`, visited)
        partial(node?.right, sum-node?.`val`, visited)
        visited.removeAt(visited.size-1)
    }
}

