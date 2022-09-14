#!/usr/bin/env python3

from copy import copy
from typing import List


class Solution:
    def __init__(self) -> None:
        self.results = []
        self.curr = []

    def partition(self, s: str) -> List[List[str]]:
        return self.helper(s, 0)
        
    def helper(self, s: str, start: int):
        if start >= len(s):
            self.results.append(copy(self.curr))
            return

        for i in range(start, len(s)):
            if self.is_palindrome(s[start:i+1]):
                self.curr.append(s[start:i+1])
                self.helper(s, i+1)
                self.curr.pop()

    def is_palindrome(self, s: str) -> bool:
        return s == s[::-1]
