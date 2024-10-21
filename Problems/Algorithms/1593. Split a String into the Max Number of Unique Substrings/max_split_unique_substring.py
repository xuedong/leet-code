#!/usr/bin/env python3


class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        seen = set()
        return self._backtrack(s, 0, seen)

    def _backtrack(self, s, start, seen):
        if start == len(s):
            return 0

        count = 0
        for end in range(start+1, len(s)+1):
            sub_string = s[start:end]
            if sub_string not in seen:
                seen.add(sub_string)
                count = max(count, 1 + self._backtrack(s, end, seen))
                seen.remove(sub_string)

        return count
