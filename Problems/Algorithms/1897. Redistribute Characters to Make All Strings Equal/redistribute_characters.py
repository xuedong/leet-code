#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        return not any([val % len(words) for val in Counter("".join(words)).values()])
