#!/usr/bin/env python3
# coding: utf-8


class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.strip().split()[::-1])
