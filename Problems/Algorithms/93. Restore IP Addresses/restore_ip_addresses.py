#!/usr/bin/env python3

import itertools
from typing import List


class Solution:
    def leading_0(self, s: str):
        return s[0] == "0" and s != "0"

    def is_valid(self, s: str):
        return not self.leading_0(s) and int(s) <= 255

    def restoreIpAddresses(self, s: str) -> List[str]:
        result = []
        for i, j, k in itertools.combinations(range(1, len(s)), 3):
            ip = [s[:i], s[i:j], s[j:k], s[k:]]
            if all([self.is_valid(string) for string in ip]):
                result.append(".".join(ip))
        return result
