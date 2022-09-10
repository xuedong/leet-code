class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        int buy = prices[0];
        for (int price : prices) {
            if (price >= buy) {
                ans += price - buy;
            }
            buy = price;
        }

        return ans;
    }
}
