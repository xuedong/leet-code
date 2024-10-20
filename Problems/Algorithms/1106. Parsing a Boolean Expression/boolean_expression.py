#!/usr/bin/env python3


class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        index = [0]

        return self._evaluate(expression, index)

    def _evaluate(self, expr: str, index: list) -> bool:
        curr = expr[index[0]]
        index[0] += 1

        if curr == "t":
            return True
        if curr == "f":
            return False

        if curr == "!":
            index[0] += 1
            res = not self._evaluate(expr, index)
            index[0] += 1
            return res

        values = []
        index[0] += 1
        while expr[index[0]] != ")":
            if expr[index[0]] != ",":
                values.append(self._evaluate(expr, index))
            else:
                index[0] += 1
        index[0] += 1

        if curr == "&":
            return all(values)
        if curr == "|":
            return any(values)

        return False
