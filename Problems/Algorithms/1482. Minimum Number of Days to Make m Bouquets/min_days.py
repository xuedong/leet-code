#!/usr/bin/env python3

from typing import List


class Solution:
    def helper(self, bloomDay, mid, k):
        num = 0
        count = 0

        for day in bloomDay:
            if day <= mid:
                count += 1
            else:
                count = 0

            if count == k:
                num += 1
                count = 0

        return num

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if m * k > len(bloomDay):
            return -1

        start, end = 0, max(bloomDay)
        ans = -1
        while start <= end:
            mid = start + (end - start) // 2
            if self.helper(bloomDay, mid, k) >= m:
                ans = mid
                end = mid - 1
            else:
                start = mid + 1

        return ans
