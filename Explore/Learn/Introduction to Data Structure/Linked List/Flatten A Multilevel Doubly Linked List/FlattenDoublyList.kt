/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {
    fun flatten(root: Node?): Node? {
        if (root == null) return null
        
        if (root.next == null && root.child == null) return root
        
        if (root.next == null && root.child != null) {
            var curr: Node? = flatten(root.child)
            root.next = curr
            root.child = null
            curr?.prev = root
            return root
        }
        
        if (root.next != null && root.child == null) {
            var curr: Node? = flatten(root.next)
            return root
        }
        
        var currNext: Node? = flatten(root.next)
        var currChild: Node? = flatten(root.child)
        root.next = currChild
        root.child = null
        currChild?.prev = root
                
        var tail: Node? = currChild
        while (tail?.next != null) {
            tail = tail?.next
        }
        tail?.next = currNext
        currNext?.prev = tail
        
        return root
    }
}

