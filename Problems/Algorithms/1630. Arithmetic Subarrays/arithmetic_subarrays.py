#!/usr/bin/env python3

from typing import List


class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        def check(arr):
            min_element, max_element = min(arr), max(arr)
            n = len(arr)

            if (max_element - min_element) % (n - 1) != 0:
                return False

            diff = (max_element - min_element) / (n - 1)
            arr_set = set(arr)
            curr = min_element + diff
            while curr < max_element:
                if curr not in arr_set:
                    return False
                curr += diff

            return True

        ans = []
        for i in range(len(l)):
            arr = nums[l[i]:r[i]+1]
            ans.append(check(arr))

        return ans
