#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        counter = defaultdict(int)
        for word in words2:
            curr = defaultdict(int)
            for ch in word:
                curr[ch] += 1
            for key in curr:
                counter[key] = max(counter[key], curr[key])

        results = []
        for word in words1:
            curr = Counter(word)
            flag = False
            for key, value in counter.items():
                if value > curr[key]:
                    flag = True
                    break
            if not flag:
                results.append(word)

        return results

