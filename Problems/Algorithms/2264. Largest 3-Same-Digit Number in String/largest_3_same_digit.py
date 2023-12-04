#!/usr/bin/env python3


class Solution:
    def largestGoodInteger(self, num: str) -> str:
        max_digit = '\0'

        for i in range(len(num)-2):
            if num[i] == num[i+1] == num[i+2]:
                max_digit = max(max_digit, num[i])

        return '' if max_digit == '\0' else max_digit * 3
