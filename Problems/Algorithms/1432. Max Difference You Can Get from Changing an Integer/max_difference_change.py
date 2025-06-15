#!/usr/bin/env python3


class Solution:
    def maxDiff(self, num: int) -> int:
        num_str_max = str(num)
        num_str_min = str(num)

        for digit in num_str_max:
            if digit != "9":
                num_str_max = num_str_max.replace(digit, "9")
                break

        for i, digit in enumerate(num_str_min):
            if i == 0:
                if digit != "1":
                    num_str_min = num_str_min.replace(digit, "1")
                    break
            else:
                if digit != "0" and digit != num_str_min[0]:
                    num_str_min = num_str_min.replace(digit, "0")
                    break

        return int(num_str_max) - int(num_str_min)
