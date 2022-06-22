class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val n1 = word1.length
        val n2 = word2.length
        val dp = Array(n1+1) { IntArray(n2+1) { 0 } }
        
        for (i in 1..n1) {
            dp[i][0] = i
        }
        for (j in 1..n2) {
            dp[0][j] = j
        }
        
        for (i in 1..n1) {
            for (j in 1..n2) {
                if (word1.get(i-1) == word2.get(j-1)) {
                    dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[i][j] = 1 + minOf(minOf(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])
                }
            }
        }
        
        return dp[n1][n2]
    }
}

