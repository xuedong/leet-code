#!/usr/bin/env python3

from typing import List


class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)
        dp = [[0 for _ in range(n2+1)] for _ in range(n1+1)]
        for i in range(1, n1+1):
            for j in range(1, n2+1):
                if nums1[i-1] == nums2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
        return max(max(row) for row in dp)
