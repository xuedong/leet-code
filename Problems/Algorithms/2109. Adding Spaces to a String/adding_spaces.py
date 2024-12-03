#!/usr/bin/env python3

from typing import List


class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        ans = []
        index = 0

        for i in range(len(s)):
            if index < len(spaces) and i == spaces[index]:
                ans.append(" ")
                index += 1
            ans.append(s[i])

        return "".join(ans)
