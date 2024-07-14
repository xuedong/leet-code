#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack = [defaultdict(int)]

        index = 0
        while index < len(formula):
            if formula[index] == "(":
                stack.append(defaultdict(int))
                index += 1
            elif formula[index] == ")":
                curr = stack.pop()
                index += 1

                multiplier = ""
                while index < len(formula) and formula[index].isdigit():
                    multiplier += formula[index]
                    index += 1
                
                if multiplier:
                    multiplier = int(multiplier)
                    for atom in curr:
                        curr[atom] *= multiplier

                for atom in curr:
                    stack[-1][atom] += curr[atom]
            else:
                atom = formula[index]
                index += 1
                while index < len(formula) and formula[index].islower():
                    atom += formula[index]
                    index += 1

                count = ""
                while index < len(formula) and formula[index].isdigit():
                    count += formula[index]
                    index += 1

                if count == "":
                    stack[-1][atom] += 1
                else:
                    stack[-1][atom] += int(count)

        final = dict(sorted(stack[0].items()))
        ans = ""
        for atom in final:
            ans += atom
            if final[atom] > 1:
                ans += str(final[atom])

        return ans
