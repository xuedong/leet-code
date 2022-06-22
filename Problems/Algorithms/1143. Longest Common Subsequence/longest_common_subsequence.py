class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n1, n2 = len(text1), len(text2)
        dp = [[0 for _ in range(n2+1)] for _ in range(n1+1)]

        for i, c1 in enumerate(text1):
            for j, c2 in enumerate(text2):
                if c1 == c2:
                    dp[i+1][j+1] = 1 + dp[i][j]
                else:
                    dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1])

        return dp[n1][n2]

