#!/usr/bin/env python3

from typing import List


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()

        ans = 0
        for a in range(n):
            for b in range(n-1, a, -1):
                product = nums[a] * nums[b]

                d_values = set()
                for c in range(a+1, b):
                    if product % nums[c] == 0:
                        d_value = product // nums[c]
                        if d_value in d_values:
                            ans += 8

                        d_values.add(nums[c])

        return ans
