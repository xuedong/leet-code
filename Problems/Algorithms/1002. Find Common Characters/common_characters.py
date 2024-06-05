#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        n = len(words)
        ans = []
        
        common = Counter(words[0])
        for i in range(1, n):
            curr = Counter(words[i])
            for letter in common.keys():
                common[letter] = min(common[letter], curr[letter])
        
        for letter, count in common.items():
            for _ in range(count):
                ans.append(letter)

        return ans
