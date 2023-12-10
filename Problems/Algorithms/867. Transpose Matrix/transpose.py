#!/usr/bin/env python3

from typing import List


class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        return zip(*matrix)
