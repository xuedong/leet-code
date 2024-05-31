#!/usr/bin/env python3

from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        total = 0
        for num in nums:
            total ^= num

        least = total & -total

        ans = [0, 0]
        for num in nums:
            if (least & num) == 0:
                ans[0] ^= num
            else:
                ans[1] ^= num

        return ans
