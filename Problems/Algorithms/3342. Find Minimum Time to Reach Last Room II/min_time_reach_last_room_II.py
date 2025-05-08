#!/usr/bin/env python3

from typing import List
import heapq


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        dp = [[float('inf')] * m for _ in range(n)]
        
        min_heap = []
        heapq.heappush(min_heap, (0, 0, 0))
        
        moveTime[0][0] = 0
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        
        while min_heap:
            curr_time, curr_row, curr_col = heapq.heappop(min_heap)
            if curr_time >= dp[curr_row][curr_col]:
                continue

            if curr_row == n - 1 and curr_col == m - 1:
                return curr_time
            
            dp[curr_row][curr_col] = curr_time
            for dr, dc in directions:
                next_row = curr_row + dr
                next_col = curr_col + dc
                if 0 <= next_row < n and 0 <= next_col < m and dp[next_row][next_col] == float('inf'):
                    cost = (curr_row + curr_col) % 2 + 1
                    next_time = max(moveTime[next_row][next_col], curr_time) + cost
                    heapq.heappush(min_heap, (next_time, next_row, next_col))
        return -1
