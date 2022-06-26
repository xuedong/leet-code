#!/usr/bin/env python3

INT_MAX = pow(2, 31) - 1
INT_MIN = -pow(2, 31)


class Solution:
    def myAtoi(self, s: str) -> int:
        n = len(s)

        sign = 1
        num = 0
        idx = 0

        while idx < n and s[idx] == ' ':
            idx += 1

        if idx < n and s[idx] == '+':
            sign = 1
            idx += 1
        elif idx < n and s[idx] == '-':
            sign = -1
            idx += 1

        while idx < n and s[idx].isdigit():
            digit = int(s[idx])
            num = 10 * num + digit
            if sign == 1 and num > INT_MAX:
                return INT_MAX
            if sign == -1 and num > INT_MAX + 1:
                return INT_MIN
            idx += 1

        return sign * num

