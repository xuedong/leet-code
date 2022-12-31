class Solution {
    int rows, cols;
    int[][] grid;
    int count;

    private boolean isValid(int row, int col) {
        return row >= 0 && row < this.rows && col >= 0 && col < this.cols;
    }

    private void backtrack(int row, int col, int rest) {
        if (this.grid[row][col] == 2 && rest == 1) {
            this.count++;
            return;
        }

        int temp = grid[row][col];
        grid[row][col] = -2;
        rest--;

        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int x = row + neighbors[i][0];
            int y = col + neighbors[i][1];

            if (!isValid(x, y) || grid[x][y] < 0) continue;

            backtrack(x, y, rest);
        }

        grid[row][col] = temp;
    }

    public int uniquePathsIII(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int rest = 0;
        int row = 0, col = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                int curr = grid[i][j];
                if (curr >= 0) {
                    rest++;
                }
                if (curr == 1) {
                    row = i;
                    col = j;
                }
            }
        }

        this.count = 0;
        this.grid = grid;

        backtrack(row, col, rest);
        return this.count;
    }
}
