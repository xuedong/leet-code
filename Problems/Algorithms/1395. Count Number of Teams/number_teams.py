#!/usr/bin/env python3

from typing import List


class Solution:
    def numTeams(self, rating: List[int]) -> int:
        n = len(rating)
        increasing = [[0] * 4 for _ in range(n)]
        decreasing = [[0] * 4 for _ in range(n)]

        for i in range(n):
            increasing[i][1] = 1
            decreasing[i][1] = 1

        for k in range(2, 4):
            for i in range(n):
                for j in range(i+1, n):
                    if rating[j] > rating[i]:
                        increasing[j][k] += increasing[i][k-1]
                    if rating[j] < rating[i]:
                        decreasing[j][k] += decreasing[i][k-1]

        ans = 0
        for i in range(n):
            ans += increasing[i][3] + decreasing[i][3]
        return ans
