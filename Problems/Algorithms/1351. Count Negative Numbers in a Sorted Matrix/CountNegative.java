class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;

        for (int[] row : grid) {
            int left = -1, right = n;
            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            count += (n - right);
        }

        return count;
    }
}
