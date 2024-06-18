#!/usr/bin/env python3

from typing import List


class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        profiles = [(0, 0)]
        for i in range(len(difficulty)):
            profiles.append((difficulty[i], profit[i]))
        profiles.sort()

        for i in range(len(profiles)-1):
            profiles[i+1] = (
                profiles[i+1][0],
                max(profiles[i][1], profiles[i+1][1])
            )

        ans = 0
        for i in range(len(worker)):
            ability = worker[i]
            
            left, right = 0, len(profiles)-1
            curr = 0
            while left <= right:
                mid = left + (right - left) // 2
                if profiles[mid][0] <= ability:
                    curr = max(curr, profiles[mid][1])
                    left = mid + 1
                else:
                    right = mid - 1
            ans += curr

        return ans
