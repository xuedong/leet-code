#!/usr/bin/env python3

import random
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.head = head

    def getRandom(self) -> int:
        scope, value = 1, 0
        curr = self.head

        while curr:
            if random.random() < 1.0 / scope:
                value = curr.val
            curr = curr.next
            scope += 1
        
        return value


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()