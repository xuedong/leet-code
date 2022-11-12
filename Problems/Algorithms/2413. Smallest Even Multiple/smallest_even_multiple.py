#!/usr/bin/env python3
# coding: utf-8


class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        return n if n % 2 == 0 else 2 * n
