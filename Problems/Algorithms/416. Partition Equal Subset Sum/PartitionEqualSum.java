class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        
        boolean[][] dp = new boolean[n+1][target+1];
        // for (int i = 0; i < n+1; i++) {
        //     Arrays.fill(dp[i], false);
        // }
    
        dp[0][0] = true;
    
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < target+1; j++) {
            dp[0][j] = false;
        }
    
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][target];
    }
}

