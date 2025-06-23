#!/usr/bin/env python3


class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def is_palindrome(x: int) -> bool:
            digits = list()
            while x:
                digits.append(x % k)
                x //= k
            return digits == digits[::-1]

        left, cnt, ans = 1, 0, 0
        while cnt < n:
            right = left * 10

            for op in [0, 1]:
                for i in range(left, right):
                    if cnt == n:
                        break

                    combined = i
                    x = i // 10 if op == 0 else i
                    while x:
                        combined = combined * 10 + x % 10
                        x //= 10

                    if is_palindrome(combined):
                        cnt += 1
                        ans += combined

            left = right

        return ans
