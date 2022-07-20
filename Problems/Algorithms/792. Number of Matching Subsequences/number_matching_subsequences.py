#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        subwords = defaultdict(list)
        for word in words:
            subwords[word[0]].append(word)

        count = 0
        for ch in s:
            candidates = subwords[ch]
            subwords[ch] = []
            for word in candidates:
                if len(word) == 1:
                    count += 1
                else:
                    subwords[word[1]].append(word[1:])

        return count

