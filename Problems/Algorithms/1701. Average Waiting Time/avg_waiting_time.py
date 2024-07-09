#!/usr/bin/env python3

from typing import List


class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        idle, wait = 0, 0
        for customer in customers:
            idle = max(customer[0], idle) + customer[1]
            wait += idle - customer[0]

        ans = wait / len(customers)
        return ans
