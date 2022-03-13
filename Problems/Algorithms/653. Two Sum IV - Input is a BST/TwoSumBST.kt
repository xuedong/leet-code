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
    private val visited = mutableSetOf<Int>()
    
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) return false
        
        val curr = k - root?.`val`
        if (visited.contains(curr)) {
            return true
        }
        visited.add(root?.`val`)
        
        if (findTarget(root?.left, k)) return true
        return findTarget(root?.right, k)
    }
}

