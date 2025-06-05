#!/usr/bin/env python3


class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word

        n = len(word)
        ans = ""
        for i in range(n):
            ans = max(ans, word[i:min(i+n-numFriends+1, n)])
        return ans
