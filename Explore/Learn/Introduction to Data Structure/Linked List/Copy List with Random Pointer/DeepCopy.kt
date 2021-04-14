/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        
        // create the interweaved list
        var head = node
        while (head != null) {
            val temp = head.next
            head.next = Node(head?.`val`)
            head.next?.next = temp
            head = head.next?.next
        }
        
        // copy the random links
        head = node
        while (head != null) {
            head.next?.random = head.random?.next
            head = head.next?.next
        }
        
        // separate the interweaved lists
        head = node
        val dummy = Node(-1)
        dummy.next = node
        var prev = dummy
        while (head != null) {
            prev.next = head.next
            head.next = head.next?.next
            prev = prev.next!!
            head = head.next
        }
        
        return dummy.next
    }
}

