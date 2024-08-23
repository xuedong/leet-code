#!/usr/bin/env python3


class Solution:
    def fractionAddition(self, expression: str) -> str:
        num, denom = 0, 1

        i = 0
        while i < len(expression):
            curr_num, curr_denom = 0, 0
            negative = False

            if expression[i] == '-' or expression[i] == '+':
                if expression[i] == '-':
                    negative = True  
                i += 1

            while i < len(expression) and expression[i].isdigit():
                val = int(expression[i])
                curr_num = curr_num * 10 + val
                i += 1

            if negative:
                curr_num *= -1

            i += 1

            while i < len(expression) and expression[i].isdigit():
                val = int(expression[i])
                curr_denom = curr_denom * 10 + val
                i += 1

            num = num * curr_denom + curr_num * denom
            denom = denom * curr_denom

        gcd = abs(self.gcd(num, denom))
        num //= gcd
        denom //= gcd

        return f"{num}/{denom}"

    def gcd(self, a, b):
        if a == 0:
            return b
        return self.gcd(b % a, a)
