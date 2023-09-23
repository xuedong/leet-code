class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[102][102];
        res[0][0] = (double) poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                double curr = (res[row][col] - 1.0) / 2.0;
                if (curr > 0) {
                    res[row+1][col] += curr;
                    res[row+1][col+1] += curr;
                }
            }
        }

        return Math.min(1, res[query_row][query_glass]);
    }
}
