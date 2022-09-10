class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[] left = new int[n];
        for (int i = 1, buy = prices[0]; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }

        int[] right = new int[n];
        for (int i = n - 2, sell = prices[n - 1]; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], sell - prices[i]);
            sell = Math.max(sell, prices[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }

        return ans;
    }
}
