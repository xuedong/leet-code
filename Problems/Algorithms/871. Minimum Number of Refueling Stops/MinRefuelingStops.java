class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        
        long[] dp = new long[n+1];
        dp[0] = startFuel;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (stations[i][0] <= dp[j]) {
                    dp[j+1] = Math.max(dp[j+1], dp[j] + (long) stations[i][1]);
                }
            }
        }

        for (int i = 0; i < n+1; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
