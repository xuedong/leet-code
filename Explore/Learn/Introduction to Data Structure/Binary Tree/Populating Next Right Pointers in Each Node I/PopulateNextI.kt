/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connectTwoNodes(node1: Node?, node2: Node?) {
        if (node1 == null && node2 == null) return
        
        node1?.next = node2
        connectTwoNodes(node1?.left, node1?.right)
        connectTwoNodes(node1?.right, node2?.left)
        connectTwoNodes(node2?.left, node2?.right)
    }
    
    fun connect(root: Node?): Node? {
        if (root == null) return null
        connectTwoNodes(root?.left, root?.right)
        return root
    }
}

