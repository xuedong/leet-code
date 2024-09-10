#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a
        
        if not head.next:
            return head

        node1, node2 = head, head.next
        while node2:
            val = gcd(node1.val, node2.val)
            node = ListNode(val)

            node1.next = node
            node.next = node2

            node1, node2 = node2, node2.next

        return head
