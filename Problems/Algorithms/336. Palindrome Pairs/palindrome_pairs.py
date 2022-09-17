#!/usr/bin/env python3

from typing import Tuple


class TrieNode:
    def __init__(self) -> None:
        self.children = {}
        self.end = False
        self.idx = -1

class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word: str, idx: int) -> None:
        node = self.root
        for i, char in enumerate(word):
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.end = True
        node.idx = idx

    def search(self, word: str) -> Tuple[bool, int]:
        node = self.root
        for i, char in enumerate(word):
            if char not in node.children:
                return False, -1
            node = node.children[char]
        return node.end, node.idx

class Solution:
    def palindromePairs(self, words):
        trie = Trie()
        for i, word in enumerate(words):
            trie.insert(word, i)
        
        results = []
        for i, word in enumerate(words):
            for j in range(len(word) + 1):
                prefix, suffix = word[:j], word[j:]
                if prefix == prefix[::-1]:
                    found, idx = trie.search(suffix[::-1])
                    if found and idx != i:
                        results.append([idx, i])
                if j != len(word) and suffix == suffix[::-1]:
                    found, idx = trie.search(prefix[::-1])
                    if found and idx != i:
                        results.append([i, idx])

        return results

    # def is_palindrome(self, word: str) -> bool:
    #     i, j = 0, len(word) - 1
    #     while i < j:
    #         if word[i] != word[j]:
    #             return False
    #         i += 1
    #         j -= 1
    #     return True