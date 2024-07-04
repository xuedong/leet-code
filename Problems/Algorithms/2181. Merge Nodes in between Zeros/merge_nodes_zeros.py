#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        left = head.next
        right = left

        while right:
            curr = 0
            while right.val != 0:
                curr += right.val
                right = right.next

            left.val = curr
            right = right.next
            left.next = right
            left = left.next

        return head.next
        