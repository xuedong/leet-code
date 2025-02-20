#!/usr/bin/env python3

from typing import List
import random


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        ints = set()
        for num in nums:
            ints.add(int(num, 2))

        ans = int(nums[0], 2)
        n = len(nums)
        while ans in ints:
            ans = random.randrange(0, 2**n)

        string = bin(ans)[2:]
        return "0" * (n-len(string)) + string
