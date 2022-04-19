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
    private var prev: TreeNode? = null
    private var first: TreeNode? = null
    private var second: TreeNode? = null
    
    fun recoverTree(root: TreeNode?): Unit {
        if (root == null) return
        
        inorder(root)
        
        val temp = first?.`val`
        first?.`val` = second?.`val`
        second?.`val` = temp
    }
    
    private fun inorder(root: TreeNode?): Unit {
        if (root == null) return
        
        inorder(root?.left)
        
        if (prev != null && root?.`val` < prev?.`val`!!) {
            if (first == null) {
                first = prev
            }
            
            second = root
        }
        prev = root
        
        inorder(root?.right)
    }
}

