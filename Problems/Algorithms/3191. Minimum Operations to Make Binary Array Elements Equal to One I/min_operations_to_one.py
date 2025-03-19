#!/usr/bin/env python3

from typing import List
from collections import deque


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        flip = deque()
        count = 0

        for i in range(len(nums)):
            while flip and i > flip[0] + 2:
                flip.popleft()

            if (nums[i] + len(flip)) % 2 == 0:
                if i + 2 >= len(nums):
                    return -1

                count += 1
                flip.append(i)

        return count
