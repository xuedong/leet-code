#!/usr/env/bin python3
# coding=utf-8

from functools import lru_cache
from typing import List


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        unique = []
        for s in arr:
            if len(s) == len(set(s)):
                unique.append(s)

        concat = [set()]
        for s in unique:
            for c in concat[:]:
                if not c & set(s):
                    concat.append(c | set(s))
        return max(len(c) for c in concat)
