#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
    
        visited = {}
        curr = head
        while curr:
            if curr in visited:
                return curr
        
            visited[curr] = True
            curr = curr.next
    
        return None
