class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        for (int top = 0; top < m; top++) {
            int[] arr = new int[n];
            for (int bottom = top; bottom < m; bottom++) {
                for (int i = 0; i < n; i++) {
                    arr[i] += matrix[bottom][i];
                }
                ans = Math.max(ans, maxSumSubarray(arr, n, k));
            }
        }

        return ans;
    }

    private int maxSumSubarray(int[] array, int n, int k) {
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            Integer lower = bst.ceiling(sum - k);
            if (lower != null) {
                max = Math.max(max, sum - lower);
            }
            bst.add(sum);
        }

        return max;
    }
}
