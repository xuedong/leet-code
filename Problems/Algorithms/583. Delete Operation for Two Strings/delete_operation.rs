impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        let s1 = word1.as_bytes();
        let s2 = word2.as_bytes();
        let n1 = word1.len();
        let n2 = word2.len();
        let mut dp = vec![vec![0; n2+1]; n1+1];
        
        for (i, c1) in s1.iter().enumerate() {
            for (j, c2) in s2.iter().enumerate() {
                if c1 == c2 {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = dp[i][j+1].max(dp[i+1][j]);
                }
            }
        }
        
        (n1 + n2 - 2 * dp[n1][n2]) as i32
    }
}

