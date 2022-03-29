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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val length = inorder.size-1
        return aux(inorder, 0, length, postorder, 0, length)
    }
    
    private fun aux(inorder: IntArray, inLeft: Int, inRight: Int, postorder: IntArray, postLeft: Int, postRight: Int): TreeNode? {
        if (postLeft > postRight) return null
        
        val root = TreeNode(postorder[postRight])
        for (i in inLeft..inRight) {
            if (inorder[i] == root.`val`) {
                root.left = aux(inorder, inLeft, i-1, postorder, postLeft, postLeft+i-inLeft-1)
                root.right = aux(inorder, i+1, inRight, postorder, postLeft+i-inLeft, postRight-1)
                break
            }
        }
        
        return root
    }
}

