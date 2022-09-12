class Solution:
    def lastRemaining(self, n: int) -> int:
        def helper(n: int, left: bool) -> int:
            if n == 1:
                return 1

            if left:
                return 2 * helper(n // 2, False)
            elif n % 2 == 0:
                return 2 * helper(n // 2, True) - 1
            else:
                return 2 * helper(n // 2, True)

        return helper(n, True)
