#!/usr/bin/env python3

from typing import List


class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        ans = []

        for query in queries:
            curr, i = 0, 0
            while i < len(nums) and curr <= query:
                curr += nums[i]
                i += 1
            if i == len(nums) and curr <= query:
                ans.append(i)
            else:
                ans.append(i-1)
        
        return ans
