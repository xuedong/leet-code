class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        boolean dp[][][] = new boolean[n+1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        dp[length][i][j] |= dp[newLength][i][j] && dp[length - newLength][i + newLength][j + newLength];
                        dp[length][i][j] |= dp[newLength][i][j + length - newLength] && dp[length - newLength][i + newLength][j];
                    }
                }
            }
        }

        return dp[n][0][0];
    }
}
