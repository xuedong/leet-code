use std::cmp;

impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        let n = triangle.len();
        let mut dp = triangle[n-1].to_vec();
        for i in (0..n-1).rev() {
            for j in 0..i+1 {
                dp[j] = triangle[i][j] + cmp::min(dp[j], dp[j+1]);
            }
        }
        dp[0]
    }
}

