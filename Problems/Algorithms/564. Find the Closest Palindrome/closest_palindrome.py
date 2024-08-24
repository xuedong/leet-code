#!/usr/bin/env python3


class Solution:
    def nearestPalindromic(self, n: str) -> str:
        length = len(n)
        idx = length // 2 - 1 if length % 2 == 0 else length // 2
        half = int(n[:idx+1])

        candidates = []
        candidates.append(self.to_palindrome(half, length % 2 == 0))
        candidates.append(self.to_palindrome(half + 1, length % 2 == 0))
        candidates.append(self.to_palindrome(half - 1, length % 2 == 0))
        candidates.append(10 ** (length - 1) - 1)
        candidates.append(10 ** length + 1)

        diff = float("inf")
        ans = 0
        ref = int(n)
        for candidate in candidates:
            if candidate == ref:
                continue

            curr_diff = abs(candidate - ref)
            if curr_diff < diff:
                diff = curr_diff
                ans = candidate
            elif curr_diff == diff:
                ans = min(ans, candidate)

        return str(ans)
    

    def to_palindrome(self, left: int, is_even: bool) -> int:
        result = left
        if not is_even:
            left = left // 10

        while left > 0:
            result = result * 10 + left % 10
            left //= 10
        return result
