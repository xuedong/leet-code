#!/usr/bin/env python3

from typing import List


class TrieNode:
    def __init__(self):
        self.children = [None] * 10


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num):
        node = self.root
        num_str = str(num)

        for digit in num_str:
            idx = int(digit)
            if not node.children[idx]:
                node.children[idx] = TrieNode()
            node = node.children[idx]

    def find(self, num):
        node = self.root
        num_str = str(num)

        length = 0
        for digit in num_str:
            idx = int(digit)
            if node.children[idx]:
                length += 1
                node = node.children[idx]
            else:
                break

        return length


class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        trie = Trie()

        for num in arr1:
            trie.insert(num)

        ans = 0
        for num in arr2:
            curr = trie.find(num)
            ans = max(ans, curr)

        return ans
