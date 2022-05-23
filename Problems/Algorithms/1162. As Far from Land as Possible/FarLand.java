class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        
        int ans = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Very important remark: we should compute the queue size
            // in prior other than put it in the for loop, as size() is
            // a method of queue, rather than an attribute.
            for (int i = 1; i <= size; i++) {
                int[] curr = queue.poll();
                
                for (int[] neighbor : neighbors) {
                    int r = curr[0] + neighbor[0];
                    int c = curr[1] + neighbor[1];
                    
                    if (isValid(n, m, r, c) && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }
            ans++;
        }
        
        if (ans <= 0) return -1;
        return ans;
    }
    
    private boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

