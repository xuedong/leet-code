#!/usr/bin/env python3

from typing import List


class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        pairs = []

        for i in range(len(nums)):
            num = str(nums[i])
            transformed = ""
            for j in range(len(num)):
                transformed = transformed + str(mapping[int(num[j])])
            value = int(transformed)

            pairs.append((value, i))

        pairs.sort()
        ans = []
        for pair in pairs:
            ans.append(nums[pair[1]])
        return ans
