#!/usr/bin/env python3


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False


class Trie:
    def __init__(self):
        self.trie = TrieNode()

    def insert(self, word: str):
        node = self.trie
        flag = False
        for char in word[::-1]:
            if char not in node.children:
                node.is_end = False
                flag = True
                node.children[char] = TrieNode()
            node = node.children[char]
        if flag:
            node.is_end = True

    def search(self, word: str):
        node = self.trie
        for char in word[::-1]:
            if char not in node.children:
                return 0
            node = node.children[char]
        return len(word)+1 if node.is_end else 0


class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        trie = Trie()
        words = list(set(words))

        for word in words:
            trie.insert(word)

        ans = 0
        for word in words:
            ans += trie.search(word)
        return ans

