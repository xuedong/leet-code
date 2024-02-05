#!/usr/bin/env python3


class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = {}
        for ch in s:
            count[ch] = count.get(ch, 0) + 1

        for i in range(len(s)):
            if count[s[i]] == 1:
                return i

        return -1
