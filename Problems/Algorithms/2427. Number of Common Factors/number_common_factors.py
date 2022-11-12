#!/usr/bin/env python3
# coding: utf-8

import math


class Solution:
    def commonFactors(self, a: int, b: int) -> int:
        return sum([(a % i == 0 and b % i == 0) for i in range(1, math.gcd(a, b) + 1)])
