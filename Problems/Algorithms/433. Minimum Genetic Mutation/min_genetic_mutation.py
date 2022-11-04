#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from typing import List


class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank:
            return -1
        bank = set(bank)
        queue = [(start, 0)]
        while queue:
            node, depth = queue.pop(0)
            if node == end:
                return depth
            for i in range(len(node)):
                for c in 'ACGT':
                    new_node = node[:i] + c + node[i + 1:]
                    if new_node in bank:
                        bank.remove(new_node)
                        queue.append((new_node, depth + 1))
        return -1
