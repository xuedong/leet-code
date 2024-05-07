#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reversed_list = self.reverse_list(head)

        carry = 0
        curr, prev = reversed_list, None
        while curr:
            value = curr.val * 2 + carry
            curr.val = value % 10
            carry = 1 if value > 9 else 0
            prev, curr = curr, curr.next

        if carry:
            prev.next = ListNode(carry)

        ans = self.reverse_list(reversed_list)
        return ans

    def reverse_list(self, node: ListNode) -> ListNode:
        prev, curr = None, node
        while curr:
            temp = curr.next
            curr.next = prev
            prev, curr = curr, temp

        return prev
        