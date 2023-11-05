#!/usr/bin/env python3

from typing import List


class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        max_element = max(arr)

        curr = arr[0]
        streak = 0
        for i in range(1, len(arr)):
            opponent = arr[i]
            if curr > opponent:
                streak += 1
            else:
                curr = opponent
                streak = 1

            if streak == k or curr == max_element:
                return curr
