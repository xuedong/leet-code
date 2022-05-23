class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        boolean[][] reachableAtlantic = new boolean[n][m];
        for (int c = 0; c < m; c++) {
            dfs(heights, n, m, n-1, c, reachableAtlantic, neighbors);
        }
        for (int r = 0; r < n; r++) {
            dfs(heights, n, m, r, m-1, reachableAtlantic, neighbors);
        }
        
        boolean[][] reachablePacific = new boolean[n][m];
        for (int c = 0; c < m; c++) {
            dfs(heights, n, m, 0, c, reachablePacific, neighbors);
        }
        for (int r = 0; r < n; r++) {
            dfs(heights, n, m, r, 0, reachablePacific, neighbors);
        }
        
        List<List<Integer>> results = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (reachableAtlantic[r][c] && reachablePacific[r][c]) {
                    results.add(Arrays.asList(r, c));
                }
            }
        }
        return results;
    }
    
    private void dfs(int[][] heights, int n, int m, int r, int c, boolean[][] reachable, int[][] neighbors) {
        reachable[r][c] = true;
            
        for (int[] neighbor : neighbors) {
            int x = r + neighbor[0];
            int y = c + neighbor[1];
            if (isValid(n, m, x, y) && !reachable[x][y] && heights[x][y] >= heights[r][c]) {
                dfs(heights, n, m, x, y, reachable, neighbors);
            }
        }
    }
    
    private boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

