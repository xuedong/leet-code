#!/usr/bin/env python3

from typing import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n = len(num)
        results = []

        def helper(string, index, prev, curr, value):
            if index == n:
                if value == target and curr == 0:
                    results.append("".join(string[1:]))
                return

            curr = curr * 10 + int(num[index])
            curr_str = str(curr)

            if curr > 0:
                helper(string, index + 1, prev, curr, value)

            string.append("+")
            string.append(curr_str)
            helper(string, index + 1, curr, 0, value + curr)
            string.pop()
            string.pop()

            if string:
                string.append("-")
                string.append(curr_str)
                helper(string, index + 1, -curr, 0, value - curr)
                string.pop()
                string.pop()

                string.append("*")
                string.append(curr_str)
                helper(string, index + 1, prev * curr, 0, value - prev + prev * curr)
                string.pop()
                string.pop()

        helper([], 0, 0, 0, 0)
        return results
