#!/usr/bin/env python3

from collections import defaultdict
Trie = lambda: defaultdict(Trie)


class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        trie = Trie()
        words = list(set(words))

        nodes = [reduce(dict.__getitem__, word[::-1], trie) for word in words]

        ans = 0
        for i, word in enumerate(words):
            ans += len(word) + 1 if len(nodes[i]) == 0 else 0
        return ans

