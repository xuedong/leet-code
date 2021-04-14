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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ans: ListNode? = ListNode(0)
        var node1: ListNode? = l1
        var node2: ListNode? = l2
        var node3: ListNode? = ans
        var carry: Int = 0
        
        while (node1 != null && node2 != null) {
            var sum: Int = node1!!.`val` + node2!!.`val` + carry
            node3?.`val` = sum % 10
            carry = sum / 10
            
            if (node1?.next == null && node2?.next == null) {
                if (carry == 1) {
                    node3?.next = ListNode(1)
                }
                return ans
            }
            
            node3?.next = ListNode(0)
            node3 = node3?.next
            node1 = node1?.next
            node2 = node2?.next
        }
        
        while (node1 != null) {
            var sum: Int = node1!!.`val` + carry
            node3?.`val` = sum % 10
            carry = sum / 10
            
            if (node1?.next == null) {
                if (carry == 1) {
                    node3?.next = ListNode(1)
                }
                return ans
            }
            
            node3?.next = ListNode(0)
            node3 = node3?.next
            node1 = node1?.next
        }
        
        while (node2 != null) {
            var sum: Int = node2!!.`val` + carry
            node3?.`val` = sum % 10
            carry = sum / 10
            
            if (node2?.next == null) {
                if (carry == 1) {
                    node3?.next = ListNode(1)
                }
                return ans
            }
            
            node3?.next = ListNode(0)
            node3 = node3?.next
            node2 = node2?.next
        }
        
        return ans
    }
}

