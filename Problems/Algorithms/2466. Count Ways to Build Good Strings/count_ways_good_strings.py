class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        mod = 10 ** 9 + 7

        dp = [-1] * (high + 1)
        dp[0] = 1

        def aux(end):
            if dp[end] != -1:
                return dp[end]
            
            count = 0
            if end >= zero:
                count += aux(end - zero)
            if end >= one:
                count += aux(end - one)
            dp[end] = count % mod
            
            return dp[end]
        
        return sum(aux(end) for end in range(low, high + 1)) % mod
