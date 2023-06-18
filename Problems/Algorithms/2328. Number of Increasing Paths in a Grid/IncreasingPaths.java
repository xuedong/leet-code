class Solution {
    int[][] dp;
    int mod = 1_000_000_007;
    int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int dfs(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = 1;
        for (int[] neighbor : neighbors) {
            int x = i + neighbor[0], y = j + neighbor[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[i][j] > grid[x][y]) {
                ans += dfs(grid, x, y);
                ans %= mod;
            }
        }

        dp[i][j] = ans;
        return ans;
    }

    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += dfs(grid, i, j);
                ans %= mod;
            }
        }

        return ans;
    }
}
