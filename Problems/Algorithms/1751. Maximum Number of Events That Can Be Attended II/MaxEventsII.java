class Solution {
    private int[][] dp;

    private int dfs(int curr, int count, int[][] events) {
        if (count == 0 || curr == events.length) {
            return 0;
        }

        if (dp[count][curr] != -1) {
            return dp[count][curr];
        }

        int next = bisectRight(events, events[curr][1]);
        dp[count][curr] = Math.max(dfs(curr + 1, count, events), events[curr][2] + dfs(next, count - 1, events));

        return dp[count][curr];
    }

    private static int bisectRight(int[][] events, int target) {
        int left = -1, right = events.length;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }   

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;

        dp = new int[k+1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events);
    }
}
