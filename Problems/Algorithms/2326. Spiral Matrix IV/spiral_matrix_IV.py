#!/usr/bin/env python3

from typing import Optional, List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        i, j = 0, 0
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        curr_dir = 0
        ans = [[-1 for _ in range(n)] for _ in range(m)]
        while head is not None:
            ans[i][j] = head.val
            new_i = i + directions[curr_dir][0]
            new_j = j + directions[curr_dir][1]

            if min(new_i, new_j) < 0 or new_i >= m or new_j >= n or ans[new_i][new_j] != -1:
                curr_dir = (curr_dir + 1) % 4
            
            i += directions[curr_dir][0]
            j += directions[curr_dir][1]

            head = head.next

        return ans
