class Solution {
    private void mark(Queue q, int i, int j, boolean[][] visited, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if (grid[i][j] == '0') {
            return;
        } else if (!visited[i][j]) {
            visited[i][j] = true;
            q.offer(new int[]{i, j});
            return;
        }
        
        return;
    }
    
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    
                    while (q.size() > 0) {
                        for (int k=1; k<=q.size(); k++) {
                            int[] curr = q.poll();
                            int row = curr[0];
                            int col = curr[1];
                        
                            visited[row][col] = true;
                            mark(q, row-1, col, visited, grid);
                            mark(q, row+1, col, visited, grid);
                            mark(q, row, col-1, visited, grid);
                            mark(q, row, col+1, visited, grid);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}

