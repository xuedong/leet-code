#!/usr/bin/env python3


class Solution:
    def __partition(self, string_num, target):
        if not string_num and target == 0:
            return True

        if target < 0:
            return False

        for i in range(len(string_num)):
            left_string_num = string_num[:i+1]
            right_string_num = string_num[i+1:]
            left = int(left_string_num)

            if self.__partition(right_string_num, target-left):
                return True

        return False

    def punishmentNumber(self, n: int) -> int:
        ans = 0

        for i in range(1, n+1):
            square = i * i
            if self.__partition(str(square), i):
                ans += square

        return ans
