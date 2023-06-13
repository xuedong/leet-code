#!/usr/bin/env python3

from typing import List


class TrieNode:
    def __init__(self):
        self.count = 0
        self.children = {}


class Trie:
    def __init__(self):
        self.trie = TrieNode()

    def insert(self, array):
        node = self.trie
        for element in array:
            if element not in node.children:
                node.children[element] = TrieNode()
            node = node.children[element]
        node.count += 1

    def search(self, array):
        node = self.trie
        for element in array:
            if element in node.children:
                node = node.children[element]
            else:
                return 0
        return node.count


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        ans = 0
        n = len(grid)

        trie = Trie()
        for row in grid:
            trie.insert(row)

        for j in range(n):
            col = [grid[i][j] for i in range(n)]
            ans += trie.search(col)

        return ans
