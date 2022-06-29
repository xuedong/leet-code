/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    visited := make(map[*ListNode]bool)
    curr := head
    for curr != nil {
        if _, ok := visited[curr]; ok {
            return curr
        }

        visited[curr] = true
        curr = curr.Next
    }

    return nil
}
