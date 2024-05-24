#!/usr/bin/env python3

from typing import List


class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        n = len(words)
        freq = [0 for i in range(26)]
        for letter in letters:
            freq[ord(letter) - 97] += 1

        def compute(subset, score, freq):
            total = 0
            for ch in range(26):
                total += subset[ch] * score[ch]
                if subset[ch] > freq[ch]:
                    return 0
            return total

        best = 0
        subset = {}
        for mask in range(1 << n):
            subset = [0 for i in range(26)]
            for i in range(n):
                if (mask & (1 << i)) > 0:
                    l = len(words[i])
                    for j in range(l):
                        subset[ord(words[i][j]) - 97] += 1

            best = max(best, compute(subset, score, freq))

        return best
