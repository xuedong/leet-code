#!/usr/bin/env python3

from typing import List


class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        return [name for height, name in sorted(zip(heights, names), reverse=True)]
