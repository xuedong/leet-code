#!/usr/bin/env python3


class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        idx = word.find(ch)
        if idx == -1:
            return word

        result = []
        for i in range(0, len(word)):
            if i <= idx:
                result.append(word[idx-i])
            else:
                result.append(word[i])
        
        return ''.join(result)
