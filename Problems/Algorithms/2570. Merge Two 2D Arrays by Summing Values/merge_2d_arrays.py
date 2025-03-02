#!/usr/bin/env python3

from typing import List


class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        i, j = 0, 0
        n1, n2 = len(nums1), len(nums2)

        merged = []
        while i < n1 and j < n2:
            if nums1[i][0] == nums2[j][0]:
                merged.append([nums1[i][0], nums1[i][1] + nums2[j][1]])
                i += 1
                j += 1
            elif nums1[i][0] < nums2[j][0]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        while i < n1:
            merged.append(nums1[i])
            i += 1

        while j < n2:
            merged.append(nums2[j])
            j += 1

        return merged
