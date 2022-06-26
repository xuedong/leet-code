class Solution:
    def isHappy(self, n: int) -> bool:
        while n != 1 and n != 4:
            n = self.get_next(n)
        return n == 1

    def get_next(self, n: int) -> int:
        return sum([int(digit)*int(digit) for digit in str(n)])

