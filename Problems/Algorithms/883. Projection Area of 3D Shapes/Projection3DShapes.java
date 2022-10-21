class Solution {
    public int projectionArea(int[][] grid) {
        int area = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    area++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            area += maxRow + maxCol;
        }
        return area;
    }
}
