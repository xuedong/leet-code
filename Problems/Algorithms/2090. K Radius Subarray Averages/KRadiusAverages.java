class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);
        if (2 * k + 1 > n) {
            return avgs;
        }

        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }
        avgs[k] = (int) (sum / (2 * k + 1));

        for (int i = 2 * k + 1; i < n; i++) {
            sum += nums[i] - nums[i - 2 * k - 1];
            avgs[i - k] = (int) (sum / (2 * k + 1));
        }

        return avgs;
    }
}
