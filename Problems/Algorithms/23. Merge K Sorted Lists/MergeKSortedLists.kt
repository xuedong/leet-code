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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq: PriorityQueue<Pair<Int, ListNode?>> = PriorityQueue<Pair<Int, ListNode?>> { a, b -> a.first - b.first }
        for (list in lists) {
            if (list != null) {
                pq.offer(Pair(list.`val`!!, list))
            }
        }
        
        val dummy = ListNode(0)
        var node = dummy
        while (!pq.isEmpty()) {
            val curr = pq.poll()
            val value = curr.first
            var list = curr.second
            
            node.next = ListNode(value)
            node = node?.next
            
            list = list?.next
            if (list != null) {
                pq.offer(Pair(list.`val`!!, list))
            }
        }
        
        return dummy.next
    }
}

