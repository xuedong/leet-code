#!/usr/bin/env python3

from typing import List


class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        ans = float("inf")
        
        start, end = 0, 0
        counts = [0] * 32

        while end < len(nums):
            self._update(counts, nums[end], 1)

            while start <= end and self._convert(counts) >= k:
                ans = min(ans, end - start + 1)
                self._update(counts, nums[start], -1)
                start += 1

            end += 1

        return -1 if ans == float("inf") else ans

    def _update(self, counts: List, num: int, delta: int) -> None:
        for i in range(32):
            if num & (1 << i):
                counts[i] += delta

    def _convert(self, counts: List) -> int:
        res = 0
        for i in range(32):
            if counts[i]:
                res |= 1 << i
        return res
