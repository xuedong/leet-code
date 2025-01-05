#!/usr/bin/env python3

from typing import List


class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)
        diff_array = [0] * n

        for shift in shifts:
            if shift[2] == 1:
                diff_array[shift[0]] += 1
                if shift[1] + 1 < n:
                    diff_array[shift[1]+1] -=1
            else:
                diff_array[shift[0]] -= 1
                if shift[1] + 1 < n:
                    diff_array[shift[1]+1] += 1
            
        ans = list(s)
        num = 0
        for i in range(n):
            num = (num + diff_array[i]) % 26
            if num < 0:
                num += 26

            ch = chr((ord(s[i]) - ord("a") + num) % 26 + ord("a"))
            ans[i] = ch

        return ''.join(ans)
