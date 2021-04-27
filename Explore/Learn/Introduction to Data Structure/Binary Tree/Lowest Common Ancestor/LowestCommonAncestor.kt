/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root == p || root == q) return root
        
        val leftAncestor: TreeNode? = lowestCommonAncestor(root?.left, p, q)
        val rightAncestor: TreeNode? = lowestCommonAncestor(root?.right, p, q)
        if (leftAncestor != null && rightAncestor != null) return root
        
        return if (leftAncestor != null) leftAncestor else rightAncestor
    }
}

