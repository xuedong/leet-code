class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        int row = m, col = n;
        
        List<Integer> result = new ArrayList<>();
        
        while (i < row && j < col) {
            for (int l = j; l < col; l++) {
                result.add(matrix[i][l]);
            }
            i++;

            for (int k = i; k < row; k++) {
                result.add(matrix[k][col-1]);
            }
            col--;
            
            if (i < row) {
                for (int l = col-1; l >= j; l--) {
                    result.add(matrix[row-1][l]);
                }
                row--;
            }

            if (j < col) {
                for (int k = row-1; k >= i; k--) {
                    result.add(matrix[k][j]);
                }
                j++;
            }
        }
        
        return result;
    }
}

