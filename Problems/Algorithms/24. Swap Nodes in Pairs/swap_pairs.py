#!/usr/bin/env python3

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
		def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
				if not head:
						return head
						
				prev, curr, ans = None, head, head.next
				while curr and curr.next:
						temp = curr.next
						if prev:
								prev.next = temp
								
						curr.next, temp.next = temp.next, curr
						prev, curr = curr, curr.next
						
				return ans or head
