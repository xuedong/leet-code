class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        modulo = 1000000007

        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        for i in range(1, n+1):
            for j in range(k+1):
                if j == 0:
                    dp[i][j] = 1
                else:
                    if j - i >= 0:
                        curr = (dp[i-1][j] - dp[i-1][j-i]) % modulo
                    else:
                        curr = dp[i-1][j]
                    dp[i][j] = (dp[i][j-1] + curr) % modulo

        if k == 0:
            return 1
        return (dp[n][k] - dp[n][k-1]) % modulo

