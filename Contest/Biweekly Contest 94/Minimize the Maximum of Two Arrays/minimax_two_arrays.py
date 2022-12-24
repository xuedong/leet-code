#!/usr/bin/env python3


class Solution:
    def minimizeSet(self, divisor1: int, divisor2: int, uniqueCnt1: int, uniqueCnt2: int) -> int:
        def gcd(a: int, b: int) -> int:
            while b != 0:
                a, b = b, a % b
            return a

        def lcm(a: int, b: int) -> int:
            return (a * b) // gcd(a, b)

        left, right = 0, 10 ** 10

        while left < right:
            mid = left + (right - left) // 2
            
            if mid - mid // divisor1 < uniqueCnt1 or mid - mid // divisor2 < uniqueCnt2:
                left = mid + 1
            elif mid - mid // lcm(divisor1, divisor2) >= uniqueCnt1 + uniqueCnt2:
                right = mid
            else:
                left = mid + 1

        return left
