class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        char[][] visited = new char[m][n];
        
        for (int[] guard : guards) {
            visited[guard[0]][guard[1]] = 'g';
        }
        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = 'w';
        }
            
        for (int[] guard : guards) {
            for (int[] delta : deltas) {
                int i = guard[0] + delta[0];
                int j = guard[1] + delta[1];
                
                while (isValid(m, n, i, j) && visited[i][j] != 'g' && visited[i][j] != 'w') {
                    visited[i][j] = 'v';
                    i += delta[0];
                    j += delta[1];
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 'g' && visited[i][j] != 'w' && visited[i][j] != 'v') {
                    ans++;
                }
            }
        }
            
        return ans;
    }
    
    private boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

