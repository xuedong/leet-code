#!/usr/bin/env python3

from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)
        if n == 0:
            return [newInterval]
        
        result = []
        
        start, end = newInterval[0], newInterval[1]
        i = 0
        while i < n:
            if end < intervals[i][0]:
                result.append(newInterval)
                break
            
            if start > intervals[i][1]:
                result.append(intervals[i])
                i += 1
            else:
                j = i
                while j < n and end >= intervals[j][0]:
                    j += 1
                result.append([min(start, intervals[i][0]), max(end, intervals[j-1][1])])
                i = j
                break
        
        while i < n:
            result.append(intervals[i])
            i += 1
        
        if start > intervals[n-1][1]:
            result.append(newInterval)
        
        return result
