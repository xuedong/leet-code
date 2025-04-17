#!/usr/bin/env python3

from typing import List


class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        n = len(nums)

        ans = 0
        for i in range(n-1):
            for j in range(i+1, n):
                if (i * j) % k == 0 and nums[i] == nums[j]:
                    ans += 1
        return ans
