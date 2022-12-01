#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']

        n = len(s)
        count_left, count_right = 0, 0
        for i in range(n//2):
            count_left = count_left + 1 if s[i] in vowels else count_left
            count_right = count_right + 1 if s[n-i-1] in vowels else count_right

        return count_left == count_right
