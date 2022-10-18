#!/usr/bin/env python3
# coding: utf-8

from typing import List


class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        return [num for num in range(left, right + 1) if self.isSelfDividing(num)]
        
    def isSelfDividing(self, num: int) -> bool:
        for digit in str(num):
            if digit == '0' or num % int(digit) != 0:
                return False
        return True
