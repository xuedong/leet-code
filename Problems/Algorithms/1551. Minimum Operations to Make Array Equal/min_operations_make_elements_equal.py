class Solution:
    def minOperations(self, n: int) -> int:
        k = n // 2
        return k * k if n % 2 == 0 else k * (k + 1)
