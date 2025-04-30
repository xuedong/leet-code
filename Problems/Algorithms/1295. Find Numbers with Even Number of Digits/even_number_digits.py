#!/usr/bin/env python3

from typing import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        even_digit_count = 0

        for num in nums:
            length = len(str(num))
            if length % 2 == 0:
                even_digit_count += 1

        return even_digit_count
