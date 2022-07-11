class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] results = new int[n];
        
        for (int i = 0; i < n; i++) {
            int curr = i;
            int next;
            for (int j = 0; j < m; j++) {
                next = curr + grid[j][curr];
                if (next < 0 || next >= n || grid[j][next] != grid[j][curr]) {
                    curr = -1;
                    break;
                }
                curr = next;
            }
            
            results[i] = curr;
        }
        
        return results;
    }
}

