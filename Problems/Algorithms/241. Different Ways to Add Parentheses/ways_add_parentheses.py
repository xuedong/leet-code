#!/usr/bin/env python3

import re
from typing import List


class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
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
        return ans
