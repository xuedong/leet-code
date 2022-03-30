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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        
        if (root?.`val` != key) {
            root?.left = deleteNode(root?.left, key)
            root?.right = deleteNode(root?.right, key)
            return root
        }
        
        if (root?.left == null && root?.right == null) {
            return null
        } else if (root?.left == null) {
            return root?.right
        } else if (root?.right == null) {
            return root?.left
        } else {
            var curr: TreeNode? = root?.right
            while (curr?.left != null) {
                curr = curr?.left
            }
            curr?.left = root?.left
            return root?.right
        }
    }
}

