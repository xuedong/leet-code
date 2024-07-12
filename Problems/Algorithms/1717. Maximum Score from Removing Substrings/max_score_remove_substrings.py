#!/usr/bin/env python3


class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        score = 0
        high = "ab" if x > y else "ba"
        low = "ba" if high == "ab" else "ab"

        first_pass = self.remove(s, high)
        count = (len(s) - len(first_pass)) // 2
        score += count * max(x, y)

        second_pass = self.remove(first_pass, low)
        count = (len(first_pass) - len(second_pass)) // 2
        score += count * min(x, y)

        return score

    def remove(self, string: str, pair: str) -> str:
        st = []
        for curr in string:
            if curr == pair[1] and st and st[-1] == pair[0]:
                st.pop()
            else:
                st.append(curr)

        return "".join(st)
