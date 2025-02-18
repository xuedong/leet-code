#!/usr/bin/env python3


class Solution:
    def smallestNumber(self, pattern: str) -> str:
        self.result = []

        self.__build_sequence(0, 0, pattern)
        return ''.join(self.result[::-1])

    def __build_sequence(self, curr: int, count: int, pattern: str) -> int:
        if curr != len(pattern):
            if pattern[curr] == "I":
                self.__build_sequence(curr+1, curr+1, pattern)
            else:
                count = self.__build_sequence(curr+1, count, pattern)

        self.result.append(str(count+1))
        return count + 1
