#!/usr/bin/env python3


class Solution:
    def reverseParentheses(self, s: str) -> str:
        n = len(s)
        opens = []
        pair = [0] * n

        for i in range(n):
            if s[i] == "(":
                opens.append(i)
            if s[i] == ")":
                j = opens.pop()
                pair[i], pair[j] = j, i

        ans = []
        curr = 0
        direction = 1

        while curr < n:
            if s[curr] == "(" or s[curr] == ")":
                curr = pair[curr]
                direction = -direction
            else:
                ans.append(s[curr])
            curr += direction

        return "".join(ans)
