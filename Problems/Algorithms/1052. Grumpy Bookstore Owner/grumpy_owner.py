#!/usr/bin/env python3

from typing import List


class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        unsatisfied = 0
        for i in range(minutes):
            unsatisfied += customers[i] * grumpy[i]

        max_unsatisfied = unsatisfied
        for i in range(minutes, n):
            unsatisfied += customers[i] * grumpy[i]
            unsatisfied -= customers[i-minutes] * grumpy[i-minutes]
            max_unsatisfied = max(max_unsatisfied, unsatisfied)

        ans = max_unsatisfied
        for i in range(n):
            ans += customers[i] * (1 - grumpy[i])

        return ans
