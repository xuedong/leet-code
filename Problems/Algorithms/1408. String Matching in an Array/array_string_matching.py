#!/usr/bin/env python3

from typing import List


class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        ans = []

        for curr in range(len(words)):
            for other in range(len(words)):
                if curr == other:
                    continue
                if words[curr] in words[other]:
                    ans.append(words[curr])
                    break
        
        return ans
