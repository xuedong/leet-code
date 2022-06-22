class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n1, n2 = len(word1), len(word2)
        dp = [[0 for _ in range(n2+1)] for _ in range(n1+1)]

        for i, c1 in enumerate(word1):
            for j, c2 in enumerate(word2):
                if c1 == c2:
                    dp[i+1][j+1] = 1 + dp[i][j]
                else:
                    dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])

        return n1 + n2 - 2 * dp[n1][n2]

