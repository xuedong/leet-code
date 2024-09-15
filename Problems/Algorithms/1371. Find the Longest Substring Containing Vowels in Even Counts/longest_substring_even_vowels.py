#!/usr/bin/env python3


class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        chars = [0] * 26
        chars[0], chars[4], chars[8], chars[14], chars[20] = 1, 2, 4, 8, 16

        mp = [-1] * 32
        ans = 0
        prefix = 0
        for i in range(len(s)):
            prefix ^= chars[ord(s[i]) - ord('a')]
            if mp[prefix] == -1 and prefix != 0:
                mp[prefix] = i

            ans = max(ans, i - mp[prefix])

        return ans
