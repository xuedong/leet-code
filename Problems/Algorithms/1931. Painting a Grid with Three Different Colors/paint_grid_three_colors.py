#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        mod = 10 ** 9 + 7

        valid = dict()
        for mask in range(3**m):
            color = list()
            curr = mask
            for i in range(m):
                color.append(curr % 3)
                curr //= 3

            if any(color[i] == color[i+1] for i in range(m-1)):
                continue

            valid[mask] = color

        adj = defaultdict(list)
        for mask1, color1 in valid.items():
            for mask2, color2 in valid.items():
                if not any(x == y for x, y in zip(color1, color2)):
                    adj[mask1].append(mask2)

        dp = [int(mask in valid) for mask in range(3**m)]
        for j in range(1, n):
            col = [0] * (3 ** m)
            for mask2 in valid.keys():
                for mask1 in adj[mask2]:
                    col[mask2] += dp[mask1]
                    if col[mask2] >= mod:
                        col[mask2] -= mod

            dp = col

        return sum(dp) % mod
