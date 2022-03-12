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
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)
        insert(root, `val`)
        return root
    }
    
    private fun insert(root: TreeNode?, `val`: Int) {
        if (root == null) {
            return
        }
        
        if (root?.`val` > `val`) {
            if (root?.left == null) root?.left = TreeNode(`val`)
            else insert(root?.left, `val`)
            return
        }
        
        if (root?.right == null) root?.right = TreeNode(`val`)
        else insert(root?.right, `val`)
        return
    }
}

