class Solution {
    int mod = 1000000007;
    int[][][] dp = new int[101][101][101];

    private int find(int idx, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        int m = group.length;
        if (idx == m) {
            return profit >= minProfit ? 1 : 0;
        }

        if (dp[idx][count][profit] != -1) {
            return dp[idx][count][profit];
        }

        int total = find(idx + 1, count, profit, n, minProfit, group, profits);
        if (count + group[idx] <= n) {
            total += find(idx + 1, count + group[idx], Math.min(minProfit, profit + profits[idx]), n, minProfit, group, profits);
        }

        return dp[idx][count][profit] = total % mod;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return find(0, 0, 0, n, minProfit, group, profit);
    }
}
