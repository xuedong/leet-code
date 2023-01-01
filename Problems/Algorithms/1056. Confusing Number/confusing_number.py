#!/usr/bin/env python3


class Solution:
    def confusingNumber(self, n: int) -> bool:
        s_in = str(n)
        s_out = s_in[::-1].translate(s_in.maketrans("0123456789", "01----9-86"))
        return '-' not in s_out and s_in != s_out
