class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] >= n-1-i) {
                dp[i] = true;
            } else {
                for (int j = i+1; j <= i+nums[i]; j++) {
                    dp[i] = dp[i] || dp[j];
                }
            }
        }
        
        return dp[0];
    }
}
