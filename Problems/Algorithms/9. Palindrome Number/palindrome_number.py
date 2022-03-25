#!/usr/bin/env python3


class Solution:
    def isPalindrome(self, x: int) -> bool:
        return str(x) == str(x)[::-1]

