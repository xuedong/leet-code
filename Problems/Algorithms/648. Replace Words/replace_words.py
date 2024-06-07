#!/usr/bin/env python3

from typing import List


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        words = sentence.split()
        roots = set(dictionary)

        def shortest_root(word, roots):
            for i in range(len(word)):
                root = word[0:i]
                if root in roots:
                    return root
            return word

        for i in range(len(words)):
            words[i] = shortest_root(words[i], roots)

        return ' '.join(words)
