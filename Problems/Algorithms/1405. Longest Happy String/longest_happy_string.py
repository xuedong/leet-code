#!/usr/bin/env python3


class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        curr_a, curr_b, curr_c = 0, 0, 0
        total = a + b + c

        result = []
        for i in range(total):
            if (a >= b and a >= c and curr_a != 2) or (a > 0 and (curr_b == 2 or curr_c == 2)):
                result.append('a')
                a -= 1
                curr_a, curr_b, curr_c = curr_a + 1, 0, 0
            elif (b >= a and b >= c and curr_b != 2) or (b > 0 and (curr_c == 2 or curr_a == 2)):
                result.append('b')
                b -= 1
                curr_a, curr_b, curr_c = 0, curr_b + 1, 0
            elif (c >= a and c >= b and curr_c != 2) or (c > 0 and (curr_a == 2 or curr_b == 2)):
                result.append('c')
                c -= 1
                curr_a, curr_b, curr_c = 0, 0, curr_c + 1

        return ''.join(result)
