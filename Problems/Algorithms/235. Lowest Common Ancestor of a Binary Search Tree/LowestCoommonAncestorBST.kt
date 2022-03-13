/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if ((root!!.`val` - p!!.`val`) * (root!!.`val` - q!!.`val`) <= 0) return root
        
        if (root!!.`val` > q!!.`val` && root!!.`val` > p!!.`val`) {
            return lowestCommonAncestor(root?.left, p, q)
        }
        return lowestCommonAncestor(root?.right, p, q)
    }
}

