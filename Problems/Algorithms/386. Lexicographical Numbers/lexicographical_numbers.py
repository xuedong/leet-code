#!/usr/bin/env python3

from typing import List


class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        orders = []

        curr = 1
        for _ in range(n):
            orders.append(curr)

            if curr * 10 <= n:
                curr *= 10
            else:
                while curr % 10 == 9 or curr >= n:
                    curr //= 10
                curr += 1

        return orders
