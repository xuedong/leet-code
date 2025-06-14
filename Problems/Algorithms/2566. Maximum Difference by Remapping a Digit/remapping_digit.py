#!/usr/bin/env python3


class Solution:
    def minMaxDifference(self, num: int) -> int:
        num_str = str(num)
        num_str_min = num_str

        pos = 0
        while pos < len(num_str) and num_str[pos] == "9":
            pos += 1
        if pos < len(num_str):
            num_str = num_str.replace(num_str[pos], "9")

        num_str_min = num_str_min.replace(num_str_min[0], "0")

        return int(num_str) - int(num_str_min)
