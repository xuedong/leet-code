class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = i;
        }
        
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        
        return dp[n];
    }
}

