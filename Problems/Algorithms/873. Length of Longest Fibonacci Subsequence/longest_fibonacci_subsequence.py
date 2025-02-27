#!/usr/bin/env python3

from typing import List


class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        nums = set(arr)

        ans = 0
        n = len(arr)
        for i in range(n):
            for j in range(i+1, n):
                prev = arr[j]
                curr = arr[i] + arr[j]
                curr_len = 2

                while curr in nums:
                    prev, curr = curr, prev + curr
                    curr_len += 1
                    ans = max(ans, curr_len)

        return ans
