#!/usr/bin/env python3


class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        def helper(n, k):
            if n == 1:
                return 0
            
            total = 2 ** (n-1)
            half = total // 2

            if k > half:
                return 1 - helper(n, k-half)
            return helper(n-1, k)
        
        return helper(n, k)
