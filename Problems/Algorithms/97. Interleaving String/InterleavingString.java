class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l3 != l1 + l2) {
            return false;
        }

        boolean[][] dp = new boolean[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] & (s2.charAt(j-1) == s3.charAt(i+j-1));
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] & (s1.charAt(i-1) == s3.charAt(i+j-1));
                } else {
                    dp[i][j] = (dp[i][j-1] & (s2.charAt(j-1) == s3.charAt(i+j-1))) | (dp[i-1][j] & (s1.charAt(i-1) == s3.charAt(i+j-1)));
                }
            }
        }

        return dp[l1][l2];
    }
}
