class Solution {
    public int[][] generateMatrix(int n) {
        int i = 0;
        int j = 0;
        int row = n;
        int col = n;
        
        int[][] result = new int[n][n];
        
        int num = 1;
        while (i < row && j < col) {
            for (int l = j; l < col; l++) {
                result[i][l] = num++;
            }
            i++;

            for (int k = i; k < row; k++) {
                result[k][col-1] = num++;
            }
            col--;
            
            if (i < row) {
                for (int l = col-1; l >= j; l--) {
                    result[row-1][l] = num++;
                }
                row--;
            }

            if (j < col) {
                for (int k = row-1; k >= i; k--) {
                    result[k][j] = num++;
                }
                j++;
            }
        }
        
        return result;
    }
}

