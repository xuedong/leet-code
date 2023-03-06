#!/usr/bin/env python3

from typing import List


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        left, right = -1, len(arr)
        while right - left > 1:
            mid = left + (right - left) // 2
            if arr[mid] - 1 - mid < k:
                left = mid
            else:
                right = mid
        return left + k + 1
