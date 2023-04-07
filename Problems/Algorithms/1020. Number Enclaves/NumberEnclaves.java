class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] neighbors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    boolean flag = false;
                    int count = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    while (!queue.isEmpty()) {
                        for (int k = 0; k < queue.size(); k++) {
                            int[] curr = queue.poll();
                            int row = curr[0];
                            int col = curr[1];
                            count++;
                        
                            visited[row][col] = true;
                            for (int[] neighbor : neighbors) {
                                int r = row + neighbor[0];
                                int c = col + neighbor[1];
                                if (r < 0 || r >= n || c < 0 || c >= m) {
                                    flag = true;
                                    continue;
                                }
                                
                                if (grid[r][c] == 0 || visited[r][c]) continue;
                                
                                visited[r][c] = true;
                                queue.offer(new int[]{r, c});
                            }
                        }
                    }
                    
                    if (!flag) {
                        ans += count;
                    }
                }
            }
        }
        
        return ans;
    }
}
