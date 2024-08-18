#!/usr/bin/env python3

import heapq


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        primes = [2, 3, 5]

        heap = []
        heapq.heappush(heap, 1)

        seen = set()
        seen.add(1)

        curr = 1
        for _ in range(n):
            curr = heapq.heappop(heap)

            for prime in primes:
                temp = curr * prime
                if temp not in seen:
                    heapq.heappush(heap, temp)
                    seen.add(temp)

        return curr
