#!/usr/bin/env python3

from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_set = set(wordDict)
        results = []
        self.backtrack(s, word_set, [], results, 0)
        return results

    def backtrack(self, string, word_set, curr, results, start):
        if start == len(string):
            results.append(' '.join(curr))
            return

        for end in range(start+1, len(string)+1):
            word = string[start:end]
            if word in word_set:
                curr.append(word)
                self.backtrack(string, word_set, curr, results, end)
                curr.pop()
