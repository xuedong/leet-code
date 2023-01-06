class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int ans = 0;
        int i = 0;
        while (coins > 0 && i < costs.length) {
            if (costs[i] <= coins) {
                ans++;
            }
            coins -= costs[i];
            i++;
        }

        return ans;
    }
}
