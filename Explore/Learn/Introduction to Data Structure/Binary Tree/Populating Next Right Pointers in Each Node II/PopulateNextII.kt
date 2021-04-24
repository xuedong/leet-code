/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun findNext(node: Node?): Node? {
        if (node == null) return null
        
        var next = node?.next
        while (next != null) {
            if (next?.left != null) return next?.left
            if (next?.right != null) return next?.right
            next = next?.next
        }
        
        return null
    }
    
    fun linkChildren(node: Node?) {
        if (node == null) return
        
        if (node?.left != null) {
            node?.left?.next = if (node?.right != null) node?.right else findNext(node)
        }
        
        if (node?.right != null) {
            node?.right?.next = findNext(node)
        }
    }
    
    fun connect(root: Node?): Node? {
        if (root == null) return null
        
        var node = root
        while (node != null) {
            linkChildren(node)
            node = node?.next
        }
        
        connect(root?.left)
        connect(root?.right)
        
        return root
    }
}

