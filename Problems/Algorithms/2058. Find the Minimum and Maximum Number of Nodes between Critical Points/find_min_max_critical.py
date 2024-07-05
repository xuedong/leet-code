#!/usr/bin/env python3

from typing import Optional, List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        result = [-1, -1]
        min_dist = float("inf")

        prev, curr = head, head.next
        index = 1
        prev_critical, first_critical = 0, 0
        while curr.next is not None:
            if (curr.val < prev.val and curr.val < curr.next.val) or (curr.val > prev.val and curr.val > curr.next.val):
                if prev_critical == 0:
                    prev_critical = index
                    first_critical = index
                else:
                    min_dist = min(min_dist, index - prev_critical)
                    prev_critical = index

            index += 1
            prev = curr
            curr = curr.next

        if min_dist != float("inf"):
            max_dist = prev_critical - first_critical
            result = [min_dist, max_dist]
        return result
