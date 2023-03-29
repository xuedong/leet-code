class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(satisfaction, dp, 0, 1);
    }

    private int helper(int[] satisfaction, int[][] dp, int index, int time) {
        if (index == satisfaction.length) {
            return 0;
        }

        if (dp[index][time] != -1) {
            return dp[index][time];
        }

        return dp[index][time] = Math.max(satisfaction[index] * time + helper(satisfaction, dp, index + 1, time + 1), helper(satisfaction, dp, index + 1, time));
    }
}
