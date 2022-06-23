impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        let (s1, s2) = (word1.as_bytes(), word2.as_bytes());
        let (n1, n2) = (word1.len(), word2.len());
        let mut dp = vec![vec![0; n2+1]; n1+1];
        
        for i in 1..=n1 {
            dp[i][0] = i;
        }
        for j in 1..=n2 {
            dp[0][j] = j;
        }
        
        for i in 1..=n1 {
            for j in 1..=n2 {
                if s1[i-1] == s2[j-1] {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + dp[i-1][j-1].min(dp[i-1][j].min(dp[i][j-1]));
                }
            }
        }
        
        dp[n1][n2] as i32
    }
}

