#!/usr/bin/env python3


class Solution:
    def maximumSwap(self, num: int) -> int:
        string = list(str(num))
        n = len(string)

        indices = [0] * n
        indices[n-1] = n-1
        for i in range(n-2, -1, -1):
            indices[i] = i if string[i] > string[indices[i+1]] else indices[i+1]

        for i in range(n):
            if string[i] < string[indices[i]]:
                string[i], string[indices[i]] = string[indices[i]], string[i]
                return int(''.join(string))

        return num
