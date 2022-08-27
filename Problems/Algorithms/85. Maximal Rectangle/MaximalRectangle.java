class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m; r1++) {
            int[] arr = new int[n];
            for (int r2 = r1; r2 < m; r2++) {
                for (int c = 0; c < n; c++) {
                    if (matrix[r2][c] == '1') {
                        arr[c]++;
                    }
                }
                ans = Math.max(ans, maximalArray(arr, r2-r1+1));
            }
        }
        return ans;
    }

    private int maximalArray(int[] array, int k) {
        int max = 0;
        int i = 0, j = 0, n = array.length;
        while (j < n) {
            if (array[j] == k) {
                max = Math.max(max, (j-i+1)*k);
            } else {
                i = j+1;
            }
            j++;
        }
        return max;
    }
}
