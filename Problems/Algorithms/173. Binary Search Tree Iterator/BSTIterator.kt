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
class BSTIterator(root: TreeNode?) {
    
    private var stack = ArrayDeque<TreeNode?>()
    
    init {
        this.goLeft(root)
    }

    fun next(): Int {
        var curr: TreeNode? = this.stack.removeLast()
        
        if (curr?.right != null) {
            this.goLeft(curr?.right)
        }
        
        return curr?.`val`!!
    }

    fun hasNext(): Boolean {
        return !this.stack.isEmpty()
    }
    
    fun goLeft(node: TreeNode?): Unit {
        var curr: TreeNode? = node
        
        while (curr != null) {
            this.stack.add(curr)
            curr = curr.left
        }
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
