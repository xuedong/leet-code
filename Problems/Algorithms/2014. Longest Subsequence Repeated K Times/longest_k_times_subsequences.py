#!/usr/bin/env python3

from collections import Counter, deque

class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        candidates = sorted([ch for ch, freq in Counter(s).items() if freq >= k], reverse=True)

        queue = deque(candidates)
        ans = ""
        while queue:
            curr = queue.popleft()
            if len(curr) > len(ans):
                ans = curr

            for candidate in candidates:
                nxt = curr + candidate
                it = iter(s)
                if all(ch in it for ch in nxt * k):
                    queue.append(nxt)

        return ans
