class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0; i < n1; i++) {
            char c1 = text1.charAt(i);
            for (int j = 0; j < n2; j++) {
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
