class Solution {
    private int helper(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i <= 0 || j <= 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i-1] == nums2[j-1]) {
            dp[i][j] = 1 + helper(i-1, j-1, nums1, nums2, dp);
        } else {
            dp[i][j] = Math.max(helper(i, j-1, nums1, nums2, dp), helper(i-1, j, nums1, nums2, dp));
        }

        return dp[i][j];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        
        int[][] dp = new int[n1+1][n2+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n1, n2, nums1, nums2, dp);
    }
}
