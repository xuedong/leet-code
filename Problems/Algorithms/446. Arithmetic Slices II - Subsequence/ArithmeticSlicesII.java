class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue; 
                }
a
                int diffInt =  (int) diff;
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + dp[j].getOrDefault(diffInt, 0) + 1);
                ans += dp[j].getOrDefault(diffInt, 0);
            }
        }

        return ans;
    }
}
