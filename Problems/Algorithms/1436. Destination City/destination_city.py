#!/usr/bin/env python3

from typing import List


class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        out = set()
        for i in range(len(paths)):
            out.add(paths[i][0])

        for i in range(len(paths)):
            if paths[i][1] not in out:
                return paths[i][1]

        return ""
