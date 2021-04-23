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
    fun aux(preorder: IntArray, preLeft: Int, preRight: Int, inorder: IntArray, inLeft: Int, inRight: Int): TreeNode? {
        if (preLeft > preRight) return null
        
        val root = TreeNode(preorder[preLeft])
        for (i in inLeft..inRight) {
            if (inorder[i] == root.`val`) {
                root.left = aux(preorder, preLeft+1, preLeft+i-inLeft, inorder, inLeft, i-1)
                root.right = aux(preorder, preLeft+i-inLeft+1, preRight, inorder, i+1, inRight)
                break
            }
        }
        
        return root
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val length = inorder.size-1
        return aux(preorder, 0, length, inorder, 0, length)
    }
}

