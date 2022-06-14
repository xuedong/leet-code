func longestCommonSubsequence(text1 string, text2 string) int {
    n1, n2 := len(text1), len(text2)
    dp := make([][]int, n1+1)
    for i := range dp {
        dp[i] = make([]int, n2+1)
    }

    for i := range dp {
        for j := range dp[0] {
            if i == 0 || j == 0 {
                continue
            }

            if text1[i-1] == text2[j-1] {
                dp[i][j] = 1 + dp[i-1][j-1]
            } else {
                if dp[i-1][j] > dp[i][j-1] {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = dp[i][j-1]
                }
            }
        }
    }

    return dp[n1][n2]
}
