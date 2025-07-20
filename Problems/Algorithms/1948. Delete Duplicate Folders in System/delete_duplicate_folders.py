#!/usr/bin/env python3

from typing import List
from collections import Counter


class Trie:
    def __init__(self):
        self.serial = ""
        self.children = dict()


class Solution:
    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        root = Trie()
        for path in paths:
            curr = root
            for node in path:
                if node not in curr.children:
                    curr.children[node] = Trie()
                curr = curr.children[node]
        
        freq = Counter()

        def construct(node: Trie) -> None:
            if not node.children:
                return

            curr = list()
            for folder, child in node.children.items():
                construct(child)
                curr.append(folder + "(" + child.serial + ")")

            curr.sort()
            node.serial = "".join(curr)
            freq[node.serial] += 1

        construct(root)

        ans = list()
        curr_path = list()

        def operate(node: Trie) -> None:
            if freq[node.serial] > 1:
                return

            if curr_path:
                ans.append(curr_path[:])

            for folder, child in node. children.items():
                curr_path.append(folder)
                operate(child)
                curr_path.pop()

        operate(root)
        return ans
