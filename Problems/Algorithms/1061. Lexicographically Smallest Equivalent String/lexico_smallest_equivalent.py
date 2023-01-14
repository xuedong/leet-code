#!/usr/bin/env python3


class Solution:
    def __init__(self):
        self.parent = [i for i in range(26)]

    def find(self, x: int) -> int:
        if self.parent[x] == x:
            return x

        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int):
        parent_x, parent_y = self.find(x), self.find(y)
        if parent_x == parent_y:
            return

        if parent_x < parent_y:
            self.parent[parent_y] = parent_x
        else:
            self.parent[parent_x] = parent_y

    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        n = len(s1)
        for i in range(n):
            self.union(ord(s1[i])-ord('a'), ord(s2[i])-ord('a'))
        
        ans = ""
        for ch in baseStr:
            ans += chr(self.find(ord(ch)-ord('a'))+ord('a'))
        return ans
