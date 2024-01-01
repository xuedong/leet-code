#!/usr/bin/env python3

from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        child, cookie = 0, 0
        while cookie < len(s) and child < len(g):
            if s[cookie] >= g[child]:
                child += 1
            cookie += 1
        
        return child
