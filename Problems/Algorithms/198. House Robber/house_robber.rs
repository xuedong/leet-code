impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut dp = vec![0; n+1];
        dp[1] = nums[0];
        
        for i in 2..=n {
            dp[i] = dp[i-1].max(nums[i-1]+dp[i-2]);
        }
        
        dp[n]
    }
}

