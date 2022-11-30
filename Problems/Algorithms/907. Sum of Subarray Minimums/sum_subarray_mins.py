#!/usr/bin/env python3
# coding=utf-8

from typing import List


class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        # 1. Find the left and right boundary of each element
        left = [0] * len(arr)
        right = [0] * len(arr)
        stack = []
        for i in range(len(arr)):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            if not stack:
                left[i] = -1
            else:
                left[i] = stack[-1]
            stack.append(i)
        stack = []
        for i in range(len(arr) - 1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            if not stack:
                right[i] = len(arr)
            else:
                right[i] = stack[-1]
            stack.append(i)
        # 2. Calculate the sum of subarray minimums
        res = 0
        for i in range(len(arr)):
            res += (i - left[i]) * (right[i] - i) * arr[i]
            res %= 10 ** 9 + 7
        # 3. Return the sum
        return res
