#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        count = defaultdict(int)
        for ch in word:
            count[ch] += 1

        ans = len(word)
        for cnt1 in count.values():
            deleted =  0
            for cnt2 in count.values():
                if cnt1 > cnt2:
                    deleted += cnt2
                elif cnt2 > cnt1 + k:
                    deleted += cnt2 - (cnt1 + k)
            ans = min(ans, deleted)

        return ans
