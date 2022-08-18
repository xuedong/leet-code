#!/usr/bin/env python3

import re
from typing import List, Dict


class Solution:
    def diffWaysToCompute(self, expression: str, memo: Dict[str, List[int]] = {}) -> List[int]:
        if expression in memo:
            return memo[expression]

        arr = re.split('[+\-*]', expression)
        n = len(arr)
        if n == 1:
            return [int(expression)]
        if n == 2:
            return [eval(expression)]
        ans = []
        for i in range(len(expression)):
            if expression[i] in '+-*':
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i+1:])
                for l in left:
                    for r in right:
                        ans.append(eval(str(l) + expression[i] + str(r)))
        memo[expression] = ans

        return ans
