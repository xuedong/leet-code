class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int m = img1[0].length;

        int[][] padding = new int[3 * n - 2][3 * m - 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                padding[i + n - 1][j + m - 1] = img1[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * m - 1; j++) {
                max = Math.max(max, convolution(img2, padding, i, j));
            }
        }

        return max;
    }

    private int convolution(int[][] img, int[][] kernel, int x, int y) {
        int ans = 0;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                ans += img[i][j] * kernel[i + x][j + y];
            }
        }
        return ans;
    }
}
