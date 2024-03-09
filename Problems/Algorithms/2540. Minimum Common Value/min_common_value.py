#!/usr/bin/env python3

from typing import List


class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)

        i, j = 0, 0
        while i < n1 and j < n2:
            if nums1[i] == nums2[j]:
                return nums1[i]
            if nums1[i] > nums2[j]:
                j += 1
            else:
                i += 1

        return -1
