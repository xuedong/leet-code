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
    fun reverse(head: ListNode?): ListNode? {
        var curr: ListNode? = head
        var prev: ListNode? = null
        var temp: ListNode? = null
        
        while (curr != null) {
            temp = curr?.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        
        return prev
    }
    
    fun isPalindrome(head: ListNode?): Boolean {
        var fst: ListNode? = head
        var sec: ListNode? = head
        
        while (fst != null && fst.next != null) {
            fst = fst?.next?.next
            sec = sec?.next
        }
        sec = reverse(sec)
        fst = head
        
        while (sec != null) {
            if (fst?.`val` != sec?.`val`) {
                return false
            }
            fst = fst?.next
            sec = sec?.next
        }
        return true
    }
}

