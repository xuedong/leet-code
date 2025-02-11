#!/usr/bin/env python3


class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        kmp = self.__lps(part)

        stack = []

        pattern_indexes = [0] * (len(s) + 1)
        str_index = 0
        pattern_index = 0
        while str_index < len(s):
            ch = s[str_index]
            stack.append(ch)

            if ch == part[pattern_index]:
                pattern_indexes[len(stack)] = pattern_index + 1
                pattern_index += 1

                if pattern_index == len(part):
                    for _ in range(len(part)):
                        stack.pop()
                    
                    pattern_index = 0 if not stack else pattern_indexes[len(stack)]
            else:
                if pattern_index != 0:
                    str_index -= 1
                    pattern_index = kmp[pattern_index-1]
                    stack.pop()
                else:
                    pattern_indexes[len(stack)] = 0

            str_index += 1

        return ''.join(stack)

    def __lps(self, pattern: str) -> list:
        n = len(pattern)
        lps = [0] * n

        curr = 1
        prefix = 0
        while curr < n:
            if pattern[curr] == pattern[prefix]:
                prefix += 1
                lps[curr] = prefix
                curr += 1
            elif prefix != 0:
                prefix = lps[prefix-1]
            else:
                lps[curr] = 0
                curr += 1

        return lps
