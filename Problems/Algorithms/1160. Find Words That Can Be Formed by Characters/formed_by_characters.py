#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        counts = Counter(chars)

        ans = 0
        for word in words:
            counts_word = Counter(word)
            flag = True
            for key in counts_word:
                if counts_word[key] > counts[key]:
                    flag = False
                    break
            if flag:
                ans += len(word)

        return ans
