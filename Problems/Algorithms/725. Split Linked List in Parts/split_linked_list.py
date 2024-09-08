#!/usr/bin/env python3

from typing import Optional, List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        n = 0
        curr = head
        while curr is not None:
            n += 1
            curr = curr.next

        size, remain = n // k, n % k

        curr = head
        ans = [None] * k
        for i in range(k):
            new_part = ListNode(0)
            tail = new_part

            curr_size = size
            if remain > 0:
                remain -= 1
                curr_size += 1
            
            for j in range(curr_size):
                tail.next = ListNode(curr.val)
                tail = tail.next
                curr = curr.next

            ans[i] = new_part.next

        return ans
