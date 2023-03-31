#!/usr/bin/env python3

from typing import List


class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        rows, cols = len(pizza), len(pizza[0])

        apples = [[0 for _ in range(cols+1)] for _ in range(rows+1)]
        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, -1, -1):
                apples[row][col] = (pizza[row][col] == 'A') + apples[row+1][col] + apples[row][col+1] - apples[row+1][col+1]

        dp = [[[0 for _ in range(cols)] for _ in range(rows)] for _ in range(k)]
        dp[0] = [[int(apples[row][col] > 0) for col in range(cols)] for row in range(rows)]

        mod = 1000000007
        for rest in range(1, k):
            for row in range(rows):
                for col in range(cols):
                    curr = 0
                    for next_row in range(row+1, rows):
                        if apples[row][col] - apples[next_row][col] > 0:
                            curr += dp[rest-1][next_row][col]
                    for next_col in range(col+1, cols):
                        if apples[row][col] - apples[row][next_col] > 0:
                            curr += dp[rest-1][row][next_col]
                    dp[rest][row][col] = curr % mod
        
        return dp[k-1][0][0]
