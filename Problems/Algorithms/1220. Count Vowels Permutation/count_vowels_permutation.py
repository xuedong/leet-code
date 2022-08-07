class Solution:
    def countVowelPermutation(self, n: int) -> int:
        mod = 10 ** 9 + 7
        dp = [[0 for _ in range(6)] for _ in range(n+1)]

        for j in range(1, 6):
            dp[1][j] = 1

        for i in range(2, n+1):
            dp[i][1] = (dp[i-1][2] + dp[i-1][3] + dp[i-1][5]) % mod
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod
            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % mod
            dp[i][4] = dp[i-1][3] % mod
            dp[i][5] = (dp[i-1][3] + dp[i-1][4]) % mod

        return sum([dp[n][i] for i in range(1, 6)]) % mod

