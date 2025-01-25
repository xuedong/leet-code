#!/usr/bin/env python3

from typing import List


class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        nums_sorted = sorted(nums)

        curr = 0
        num_to_group = {}
        num_to_group[nums_sorted[0]] = curr

        group_to_list = {}
        group_to_list[curr] = [nums_sorted[0]]

        for i in range(1, len(nums)):
            if abs(nums_sorted[i] - nums_sorted[i-1]) > limit:
                curr += 1

            num_to_group[nums_sorted[i]] = curr
            if curr not in group_to_list:
                group_to_list[curr] = []
            group_to_list[curr].append(nums_sorted[i])

        for i in range(len(nums)):
            num = nums[i]
            group = num_to_group[num]
            nums[i] = group_to_list[group].pop(0)

        return nums
