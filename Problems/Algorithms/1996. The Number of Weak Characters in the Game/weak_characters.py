#!/usr/bin/env python3

from typing import List


class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda x: (-x[0], x[1]))

        ans, curr = 0, 0
        for _, defense in properties:
            if defense < curr:
                ans += 1
            else:
                curr = defense

        return ans
