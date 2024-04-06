#!/usr/bin/env python3


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        open = 0
        arr = list(s)
        n = len(arr)

        for i in range(n):
            if arr[i] == '(':
                open += 1
            elif arr[i] == ')':
                if open == 0:
                    arr[i] = '*'
                else:
                    open -= 1

        for i in range(n-1, -1, -1):
            if open > 0 and arr[i] == '(':
                arr[i] = '*'
                open -= 1

        return ''.join(ch for ch in arr if ch != '*')
