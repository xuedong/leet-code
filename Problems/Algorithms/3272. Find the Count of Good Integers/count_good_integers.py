#!/usr/bin/env python3

from math import factorial


class Solution:
    def countGoodIntegers(self, n: int, k: int) -> int:
        palindromes = set()
        base = 10 ** ((n-1) // 2)
        skip = n & 1 # odd or even

        for i in range(base, base * 10):
            string = str(i)
            string += string[::-1][skip:]

            palindrome = int(string)
            if palindrome % k == 0:
                sorted_string = "".join(sorted(string))
                palindromes.add(sorted_string)

        factorials = [factorial(i) for i in range(n+1)]
        ans = 0
        for palindrome in palindromes:
            counts = [0] * 10
            for ch in palindrome:
                counts[int(ch)] += 1

            total = (n - counts[0]) * factorials[n-1]
            for count in counts:
                total //= factorials[count]
            ans += total

        return ans
