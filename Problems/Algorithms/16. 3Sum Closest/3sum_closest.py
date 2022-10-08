#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        ans = sum(nums[:3])
        nums.sort()

        for i in range(len(nums) - 2):
            j, k = i + 1, len(nums) - 1
            while j < k:
                curr = nums[i] + nums[j] + nums[k]
                if curr == target:
                    return target
                if abs(curr - target) < abs(ans - target):
                    ans = curr
                if curr > target:
                    k -= 1
                else:
                    j += 1

        return ans
