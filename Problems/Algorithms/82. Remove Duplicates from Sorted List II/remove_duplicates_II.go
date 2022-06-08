/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    dummy := &ListNode{0, nil}
    curr := head
    prev := dummy

    for curr != nil && curr.Next != nil {
        if curr.Val == curr.Next.Val {
            for curr != nil && curr.Next != nil && curr.Val == curr.Next.Val {
                curr = curr.Next
            }
        } else {
            prev.Next = curr
            prev = curr
        }
        curr = curr.Next
    }
    prev.Next = curr

    return dummy.Next
}
