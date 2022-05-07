class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                ans = Math.max(ans, dfs(grid, visited, n, m, r, c));
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int[][] visited, int n, int m, int r, int c) {
        if (!isValid(n, m, r, c) || grid[r][c] == 0 || visited[r][c] == 1) return 0;
        
        visited[r][c] = 1;
        return 1 + dfs(grid, visited, n, m, r+1, c) + dfs(grid, visited, n, m, r-1, c) + dfs(grid, visited, n, m, r, c+1) + dfs(grid, visited, n, m, r, c-1);
    }
    
    private boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}

