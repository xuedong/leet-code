#!/usr/bin/env python3

from typing import List


class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        ans = []

        for i in range(1, 10):
            curr = i
            next_digit = i+1

            while curr <= high and next_digit <= 9:
                curr = curr * 10 + next_digit
                next_digit += 1
                if low <= curr <= high:
                    ans.append(curr)

        ans.sort()
        return ans
