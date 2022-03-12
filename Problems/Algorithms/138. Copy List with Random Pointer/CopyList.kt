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
        val map: MutableMap<Node?, Node?> = mutableMapOf<Node?, Node?>()
        var dummy: Node? = Node(-10001)
        
        var current: Node? = node
        var copy: Node? = dummy
        while (current != null) {
            copy?.next = Node(current.`val`)
            map.put(current, copy?.next)
            current = current?.next
            copy = copy?.next
        }
        
        current = node
        copy = dummy?.next
        while (current != null) {
            if (current?.random != null) {
                copy?.random = map[current?.random]
            }
            current = current?.next
            copy = copy?.next
        }
        
        return dummy?.next
    }
}

