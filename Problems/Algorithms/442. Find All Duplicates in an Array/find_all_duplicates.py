#!/usr/bin/env python3

from typing import List


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        result = []

        for num in nums:
            num = abs(num)
            if nums[num-1] < 0:
                result.append(num)
            nums[num-1] *= -1

        return result
