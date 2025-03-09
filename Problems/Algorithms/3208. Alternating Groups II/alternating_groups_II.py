#!/usr/bin/env python3

from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        n = len(colors)
        count = 1
        last = colors[0]

        result = 0
        for i in range(1, n):
            if colors[i] == last:
                count = 1
                last_color = colors[i]
                continue

            count += 1
            if count >= k:
                result += 1
            last = colors[i]

        for i in range(k-1):
            if colors[i] == last:
                break

            count += 1
            if count >= k:
                result += 1
            last = colors[i]

        return result
