#!/usr/bin/env python3

from typing import List


class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)

        lis = [1] * n
        lds = [1] * n

        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    lis[i] = max(lis[i], lis[j]+1)

        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                if nums[i] > nums[j]:
                    lds[i] = max(lds[i], lds[j]+1)

        ans = float("inf")
        for i in range(n):
            if lis[i] > 1 and lds[i] > 1:
                ans = min(ans, n-lis[i]-lds[i]+1)

        return ans
