class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] ageScore = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScore[i][0] = ages[i];
            ageScore[i][1] = scores[i];
        }

        Arrays.sort(ageScore, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[n];
        dp[0] = ageScore[0][1];
        for (int i = 1; i < n; i++) {
            int curr = ageScore[i][1];
            for (int j = 0; j < i; j++) {
                if (ageScore[i][1] >= ageScore[j][1]) {
                    curr = Math.max(curr, dp[j] + ageScore[i][1]);
                }
            }
            dp[i] = curr;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
