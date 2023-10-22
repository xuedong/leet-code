#!/usr/bin/env python3

from typing import List


class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left, right = k, k
        min_val = nums[k]
        max_score = min_val

        while left > 0 or right < n - 1:
            if left == 0 or (right < n - 1 and nums[right+1] > nums[left-1]):
                right += 1
            else:
                left -= 1
            
            min_val = min(min_val, nums[left], nums[right])
            max_score = max(max_score, min_val * (right - left + 1))

        return max_score
