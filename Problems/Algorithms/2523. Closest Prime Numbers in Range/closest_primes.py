#!/usr/bin/env python3

from typing import List


class Solution:
    def __sieve(self, upper):
        sieve = [True] * (upper + 1)
        sieve[0] = sieve[1] = False

        for num in range(2, int(upper ** 0.5) + 1):
            if sieve[num]:
                for multiple in range(num * num, upper + 1, num):
                    sieve[multiple] = False

        return sieve

    def closestPrimes(self, left: int, right: int) -> List[int]:
        all_primes = self.__sieve(right)
        primes = [num for num in range(left, right+1) if all_primes[num]]

        if len(primes) < 2:
            return -1, -1

        min_diff = float("inf")
        ans = (-1, -1)
        for i in range(1, len(primes)):
            diff = primes[i] - primes[i-1]
            if diff < min_diff:
                min_diff = diff
                ans = primes[i-1], primes[i]

        return ans
