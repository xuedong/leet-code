class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        
        int n = image.length;
        int m = image[0].length;
        if (color != newColor) {
            dfs(image, n, m, sr, sc, color, newColor);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int n, int m, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            
            int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] neighbor : neighbors) {
                int x = r + neighbor[0];
                int y = c + neighbor[1];
                if (isValid(n, m, x, y)) {
                    dfs(image, n, m, x, y, color, newColor);
                }
            }
        }
    }
    
    private Boolean isValid(int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

