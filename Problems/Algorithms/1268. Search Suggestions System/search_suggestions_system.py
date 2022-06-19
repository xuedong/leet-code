#!/usr/bin/env python3


class TrieNode:
    def __init__(self):
        self.children = {}
        self.suggestions = []


class Trie:
    def __init__(self):
        self.trie = TrieNode()

    def insert(self, word: str):
        node = self.trie
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]

            node.suggestions.append(word)
            node.suggestions.sort()
            while len(node.suggestions) > 3:
                node.suggestions.pop()

    def search(self, word: str) -> List[str]:
        node = self.trie

        ans = []
        for char in word:
            if char not in node.children:
                break
            node = node.children[char]
            ans.append(node.suggestions)

        for _ in range(len(word)-len(ans)):
            ans.append([])
        return ans


class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        trie = Trie()
        for product in products:
            trie.insert(product)
        return trie.search(searchWord)

