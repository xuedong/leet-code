#!/usr/bin/env python3


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        start, end = ListNode(), list1
        for index in range(b):
            if index == a-1:
                start = end
            end = end.next

        start.next = list2
        while list2.next is not None:
            list2 = list2.next
        list2.next = end.next

        return list1
