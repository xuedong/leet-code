#!/usr/bin/env python3

from typing import List


class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        map = {ch: idx for idx, ch in enumerate(order)}
        words = [[map[ch] for ch in word] for word in words]
        return all(word1 <= word2 for word1, word2 in zip(words[:-1], words[1:]))
