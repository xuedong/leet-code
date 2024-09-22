#!/usr/bin/env python3


class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        curr = 1

        k -= 1
        while k > 0:
            step = self.count(n, curr, curr+1)
            if step <= k:
                curr += 1
                k -= step
            else:
                curr *= 10
                k -= 1

        return curr

    def count(self, n, prefix1, prefix2):
        steps = 0
        while prefix1 <= n:
            steps += min(n+1, prefix2) - prefix1
            prefix1 *= 10
            prefix2 *= 10

        return steps
