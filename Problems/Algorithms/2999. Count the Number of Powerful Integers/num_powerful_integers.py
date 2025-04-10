#!/usr/bin/env python3


class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        return self.__compute(str(finish), s, limit) - self.__compute(str(start-1), s, limit)

    def __compute(self, x: str, s: str, limit: int) -> int:
        if len(x) < len(s):
            return 0

        if len(x) == len(s):
            return 1 if x >= s else 0

        count = 0
        pre = len(x) - len(s)
        suffix = x[pre:]

        for i in range(pre):
            if limit < int(x[i]):
                count += (limit+1) ** (pre-i)
                return count
            count += int(x[i]) * (limit+1) ** (pre-1-i)

        if suffix >= s:
            count += 1
        return count
