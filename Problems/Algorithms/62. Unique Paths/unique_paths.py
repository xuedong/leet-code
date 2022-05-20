class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def fact(n: int) -> int:
            if n == 0 or n == 1:
                return 1;
            return n * fact(n-1)

        return fact(m+n-2) // (fact(m-1) * fact(n-1))

