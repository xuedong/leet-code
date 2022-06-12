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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (subRoot != null && root == null) return false
        
        if (root?.`val` == subRoot?.`val`) {
            return isIdentical(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
        }
        return isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }
    
    private fun isIdentical(tree1: TreeNode?, tree2: TreeNode?): Boolean {
        if (tree1 == null && tree2 == null) return true
        if (tree1 == null && tree2 != null) return false
        if (tree1 != null && tree2 == null) return false
        return tree1?.`val` == tree2?.`val` && isIdentical(tree1?.left, tree2?.left) && isIdentical(tree1?.right, tree2?.right)
    }
}

