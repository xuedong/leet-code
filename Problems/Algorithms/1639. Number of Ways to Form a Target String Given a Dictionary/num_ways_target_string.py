class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        mod = 1000000007

        n, k = len(target), len(words[0])
        counts = [[0 for _ in range(k)] for _ in range(26)]
        for j in range(k):
            for word in words:
                counts[ord(word[j]) - ord('a')][j] += 1

        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        dp[0][0] = 1
        for i in range(n+1):
            for j in range(k):
                if i < n:
                    dp[i+1][j+1] += counts[ord(target[i]) - ord('a')][j] * dp[i][j]
                    dp[i+1][j+1] %= mod
                
                dp[i][j+1] += dp[i][j]
                dp[i][j+1] %= mod
        
        return dp[n][k]
