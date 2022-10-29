#!/usr/bin/env python3
# coding: utf-8

from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)
        for s in strs:
            ans[''.join(sorted(s))].append(s)
        return list(ans.values())
