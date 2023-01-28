#!/usr/bin/env python3

from collections import defaultdict


class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        marker = self.root
        for char in word:
            marker = marker.children[char]
        marker.is_end = True

class Solution:
    def findAllConcatenatedWordsInADict(self, words):
        def dfs(word, start, root, count):
            n = len(word)
            marker = root

            for i in range(start, n):
                marker = marker.children[word[i]]
                if marker.is_end:
                    if i == n-1:
                        return count >= 1
                    elif dfs(word, i+1, root, count+1):
                        return True

            return False

        trie = Trie()
        for word in words:
            trie.insert(word)

        res = []
        for word in words:
            if dfs(word, 0, trie.root, 0):
                res.append(word)

        return res
