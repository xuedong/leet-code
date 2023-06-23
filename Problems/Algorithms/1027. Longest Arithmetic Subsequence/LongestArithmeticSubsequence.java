class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];

        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int difference = nums[right] - nums[left];
                dp[right].put(difference, dp[left].getOrDefault(difference, 1) + 1);
                ans = Math.max(ans, dp[right].get(difference));
            }
        }

        return ans;
    }
}
