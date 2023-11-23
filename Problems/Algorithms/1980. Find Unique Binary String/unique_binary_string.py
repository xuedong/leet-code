#!/usr/bin/env python3

from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        ints = set()
        for num in nums:
            ints.add(int(num, 2))

        n = len(nums)
        for num in range(n+1):
            if num not in ints:
                ans = bin(num)[2:]
                return "0" * (n - len(ans)) + ans
        
        return ""
