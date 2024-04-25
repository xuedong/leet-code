class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            for (int j = ch; j >= 0 && j >= ch-k; j--) {
                dp[ch] = Math.max(dp[ch], dp[j]+1);
            }
            for (int j = ch+1; j < 26 && j <= ch+k; j++) {
                dp[ch] = Math.max(dp[ch], dp[j]+1);
            }
            ans = Math.max(ans, dp[ch]);
        }
        
        return ans;
    }
}
