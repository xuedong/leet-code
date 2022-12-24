#!/usr/bin/env python3

from collections import Counter
from math import factorial


class Solution:
    def countAnagrams(self, s: str) -> int:
        words = s.split(" ")
        
        ans = 1
        for word in words:
            curr = self.count_single(word)
            ans = (ans * curr) % 1000000007
        
        return ans
    
    def count_single(self, word: str) -> int:
        count = 1
        for i in Counter(word).values():
            count *= factorial(i)
        return factorial(len(word)) // count
