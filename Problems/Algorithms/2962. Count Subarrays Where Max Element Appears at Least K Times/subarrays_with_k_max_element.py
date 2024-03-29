#!/usr/bin/env python3

from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_element = max(nums)
        ans = 0

        i, count = 0, 0
        for j in range(len(nums)):
            if nums[j] == max_element:
                count += 1
            
            while count == k:
                if nums[i] == max_element:
                    count -= 1
                i += 1
            ans += i

        return ans
