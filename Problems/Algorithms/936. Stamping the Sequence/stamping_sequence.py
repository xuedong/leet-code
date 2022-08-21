#!/usr/bin/env python3

from typing import List


class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        n, m = len(stamp), len(target)
        stamp, target = list(stamp), list(target)
        results = []

        def check(i):
            flag = False
            for j in range(n):
                if target[i+j] == '?':
                    continue
                if stamp[j] != target[i+j]:
                    return False
                flag = True
            if flag:
                target[i:i+n] = ['?'] * n
                results.append(i)
            return flag

        flag = True
        while flag:
            flag = False
            for i in range(m-n+1):
                if check(i):
                    flag = True

        return results[::-1] if target == ['?'] * m else []
