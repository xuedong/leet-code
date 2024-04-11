#!/usr/bin/env python3


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num:
            return ""

        stack = []
        stack.append(num[0])

        for i in range(1, len(num)):
            curr = num[i]
            while stack and stack[-1] > curr and k:
                stack.pop()
                k -= 1
            stack.append(curr)

        while k:
            stack.pop()
            k -= 1

        ans = "".join(stack).lstrip("0")
        return ans if ans != "" else "0"
