#!/usr/bin/env python3


class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        arr = sorted(s)

        second = len(arr) - 2
        for i in range(len(arr) // 2):
            arr[i], arr[second-i] = arr[second-i], arr[i]

        return "".join(arr)
