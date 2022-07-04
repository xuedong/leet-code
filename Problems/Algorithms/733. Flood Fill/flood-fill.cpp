class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, color);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= image.size() || j < 0 || j >= image[0].size() || image[i][j] != color || image[i][j] == newColor) {
            return;
        }
        
        image[i][j] = newColor;
        dfs(image, i-1, j, color, newColor);
        dfs(image, i+1, j, color, newColor);
        dfs(image, i, j-1, color, newColor);
        dfs(image, i, j+1, color, newColor);
    }
};

