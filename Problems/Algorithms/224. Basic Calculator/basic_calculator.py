#!/usr/bin/env python3
# coding: utf-8


class Solution:
    def calculate(self, s: str) -> int:
        stack = []

        ans, num, sign = 0, 0, 1
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c in '+-':
                ans += sign * num
                num = 0
                sign = 1 if c == '+' else -1
            elif c == '(':
                stack.append(ans)
                stack.append(sign)
                ans, sign = 0, 1
            elif c == ')':
                ans += sign * num
                ans *= stack.pop()
                ans += stack.pop()
                num = 0
        
        return ans + sign * num
