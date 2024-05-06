#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = head
        stack = []
        while curr:
            while stack and stack[-1].val < curr.val:
                stack.pop()
            stack.append(curr)
            curr = curr.next
        
        nxt = None
        while stack:
            curr = stack.pop()
            curr.next = nxt
            nxt = curr
        
        return curr
