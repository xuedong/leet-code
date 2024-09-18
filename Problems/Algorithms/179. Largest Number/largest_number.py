#!/usr/bin/env python3

from typing import List


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        strings = [str(num) for num in nums]
        strings.sort(key=lambda a: a * 10, reverse=True)

        if strings[0] == "0":
            return "0"
        return "".join(strings)
