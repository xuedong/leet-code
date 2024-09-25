#!/usr/bin/env python3

from typing import List


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.count = 0


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if node.children[ord(ch) - ord("a")] is None:
                node.children[ord(ch) - ord("a")] = TrieNode()
            
            node.children[ord(ch) - ord("a")].count += 1
            node = node.children[ord(ch) - ord("a")]

    def count(self, word):
        node = self.root

        ans = 0
        for ch in word:
            ans += node.children[ord(ch) - ord("a")].count
            node = node.children[ord(ch) - ord("a")]
        return ans


class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = Trie()

        n = len(words)
        for i in range(n):
            trie.insert(words[i])

        scores = [0] * n
        for i in range(n):
            scores[i] = trie.count(words[i])
        return scores
