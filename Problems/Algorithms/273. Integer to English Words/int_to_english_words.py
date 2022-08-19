#!/usr/bin/env python3

from typing import List


class Solution:
    def __init__(self) -> None:
        self.single = ["One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        return ' '.join(self.helper(num))

    def helper(self, num: int) -> List[str]:
        if num == 0:
            return []
        if num < 20:
            return [self.single[num - 1]]
        if num < 100:
            return [self.tens[num // 10 - 2]] + self.helper(num % 10)
        if num < 1000:
            return [self.single[num // 100 - 1]] + ["Hundred"] + self.helper(num % 100)
        for power, word in enumerate(self.thousands, 1):
            if num < 1000 ** (power + 1):
                return self.helper(num // 1000 ** power) + [word] + self.helper(num % 1000 ** power)
