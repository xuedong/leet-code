/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        var node = head
        var count = 0
        while (node != null) {
            count++
            node = node.next
        }

        if (count == 1) return null
        if (count == 2) {
            head?.next = null
            return head
        }
        var mid = count / 2
        node = head
        while (mid > 1) {
            node = node?.next
            mid--
        }
        node?.next = node?.next?.next
        return head
    }
}
