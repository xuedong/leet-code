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
    var count = 0
    val covered: HashSet<TreeNode?>
    
    init {
        covered = hashSetOf()
    }
    
    fun minCameraCover(root: TreeNode?): Int {
        covered.add(null)
        helper(root, null)
        
        return count
    }
    
    private fun helper(node: TreeNode?, parent: TreeNode?): Unit {
        if (node != null) {
            helper(node!!.left, node)
            helper(node!!.right, node)
            
            var flag = false
            
            if (!covered.contains(node!!.left)) {
                covered.add(node)
                covered.add(node!!.left)
                covered.add(parent)
                flag = true
            }
            
            if (!covered.contains(node!!.right)) {
                covered.add(node)
                covered.add(node!!.right)
                covered.add(parent)
                flag = true
            }
            
            if (parent == null && !covered.contains(node)) {
                covered.add(node)
                flag = true
            }
            
            if (flag) count++
        }
    }
}

