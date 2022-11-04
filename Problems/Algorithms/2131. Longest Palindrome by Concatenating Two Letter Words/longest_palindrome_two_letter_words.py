#!/usr/bin/env python3
# coding: utf-8

from collections import defaultdict
from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        words_dict = defaultdict(int)

        ans = 0
        for word in words:
            if word[::-1] in words_dict and words_dict[word[::-1]] > 0:
                words_dict[word[::-1]] -= 1
                ans += 4
            else:
                words_dict[word] += 1

        for word in words_dict:
            if word[0] == word[1] and words_dict[word] > 0:
                ans += 2
                break
        return ans
