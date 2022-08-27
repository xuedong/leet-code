#!/usr/bin/env python3

import math
from typing import List
from sortedcontainers import SortedList


class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        ans = -math.inf
        for top in range(m):
            arr = [0] * n
            for bottom in range(top, m):
                for i in range(n):
                    arr[i] += matrix[bottom][i]
                ans = max(ans, self.max_sum_subarray(arr, n, k))            
        return ans

    def max_sum_subarray(self, arr: List[int], n: int, k: int) -> int:
        sums = SortedList([0])
        right = 0
        ans = -math.inf
        for i in range(n):
            right += arr[i]
            left = self.ceiling(sums, right - k)
            if left is not None:
                ans = max(ans, right - left)
            sums.add(right)
        return ans

    def ceiling(self, sorted_list: SortedList, k: int) -> int:
        idx = sorted_list.bisect_left(k)
        if idx < len(sorted_list):
            return sorted_list[idx]
        return None
