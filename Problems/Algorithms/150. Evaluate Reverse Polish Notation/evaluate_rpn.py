#!/usr/bin/env python3

from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        token = tokens[0]
        stack.append(token)
        ans = int(token)

        for i in range(len(tokens)):
            token = tokens[i]
            if token not in ["+", "-", "*", "/"]:
                stack.append(token)
                continue
            
            a = int(stack.pop())
            b = int(stack.pop())
            if token == "+":
                ans = a + b
            elif token == "-":
                ans = b - a
            elif token == "*":
                ans = a * b
            elif token == "/":
                ans = int(b / a)
            stack.append(str(ans))
        
        return ans
