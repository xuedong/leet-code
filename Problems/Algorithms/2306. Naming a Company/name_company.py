#!/usr/bin/env python3

from typing import List


class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        initials = [set() for _ in range(26)]
        for idea in ideas:
            initials[ord(idea[0]) - ord('a')].add(idea[1:])
        
        ans = 0
        for i in range(25):
            for j in range(i+1, 26):
                curr = len(initials[i] & initials[j])

                ans += 2 * (len(initials[i]) - curr) * (len(initials[j]) - curr)
                
        return ans
