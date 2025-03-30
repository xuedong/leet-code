#!/usr/bin/env python3

from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_occurrence = [0] * 26
        for i, ch in enumerate(s):
            last_occurrence[ord(ch) - ord("a")] = i

        start, end = 0, 0
        sizes = []

        for i, ch in enumerate(s):
            end = max(end, last_occurrence[ord(ch) - ord("a")])

            if i == end:
                sizes.append(i - start + 1)
                start = i + 1

        return sizes
