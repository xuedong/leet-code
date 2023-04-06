class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int curr = dfs(grid, visited, n, m, r, c);
                if (curr > 0) {
                    ans++;
                } 
            }
        }
        
        return ans;
    }

    private boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    
    private boolean isCorner(int n, int m, int r, int c) {
        return r == 0 || c == 0 || r == n-1 || c == m-1;
    }
    
    private int dfs(int[][] grid, int[][] visited, int n, int m, int r, int c) {
        if (!isValid(n, m, r, c) || visited[r][c] == 1 || grid[r][c] == 1) return 0;
        if (isCorner(n, m, r, c)) return -1000;
        
        visited[r][c] = 1;
        return 1 + dfs(grid, visited, n, m, r+1, c) + dfs(grid, visited, n, m, r-1, c) + dfs(grid, visited, n, m, r, c+1) + dfs(grid, visited, n, m, r, c-1);
    }
}
