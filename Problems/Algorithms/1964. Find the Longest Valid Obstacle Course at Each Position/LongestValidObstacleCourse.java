class Solution {
    private int bisect(int[] arr, int target, int right) {
        if (right == 0) return 0;

        int left = -1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int right = 0;

        int[] results = new int[n];
        int[] lis = new int[n];
        
        for (int i = 0; i < n; i++) {
            int height = obstacles[i];

            int insertion = bisect(lis, height, right);
            if (insertion == right) {
                right++;
            }

            lis[insertion] = height;
            results[i] = insertion + 1;
        }

        return results;
    }
}
