#!/usr/bin/env python3
# coding: utf-8


class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return '1'
        else:
            s = self.countAndSay(n - 1)
            count = 1
            result = ''
            for i in range(1, len(s)):
                if s[i] == s[i - 1]:
                    count += 1
                else:
                    result += str(count) + s[i - 1]
                    count = 1
            result += str(count) + s[-1]
            return result
