#!/usr/bin/env python3

from typing import List


class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        starts = sorted(interval[0] for interval in intervals)
        ends = sorted(interval[1] for interval in intervals)
        
        count, ans = 0, 0
        for start in starts:
            if start > ends[count]:
                count += 1
            else:
                ans += 1

        return ans
