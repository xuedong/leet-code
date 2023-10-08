#!/usr/bin/env python3

from typing import List


class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)
        dp = [[float('-inf')] * n2 for _ in range(n1)]

        def helper(i, j):
            if i == n1 or j == n2:
                return float('-inf')

            if dp[i][j] != float('-inf'):
                return dp[i][j]

            dp[i][j] = max(
                nums1[i] * nums2[j] + max(helper(i+1, j+1), 0),
                helper(i+1, j),
                helper(i, j+1),
            )

            return dp[i][j]

        return helper(0, 0)
